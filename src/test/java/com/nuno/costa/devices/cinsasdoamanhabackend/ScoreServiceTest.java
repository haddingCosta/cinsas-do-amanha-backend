package com.nuno.costa.devices.cinsasdoamanhabackend;

import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreRequest;
import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreResponse;
import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import com.nuno.costa.devices.cinsasdoamanhabackend.repository.ScoreRepository;
import com.nuno.costa.devices.cinsasdoamanhabackend.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

	@Mock
	private ScoreRepository scoreRepository;

	@InjectMocks
	private ScoreService scoreService;

	@Test
	void shouldSaveScoreSuccessfully() {
		// Arrange (Preparação)
		ScoreRequest request = new ScoreRequest();
		request.setPlayerName("Nuno");
		request.setScoreValue(1500);
		request.setEmail("nuno@example.com");

		String userId = "supabase-user-123";

		Score mockSavedScore = new Score();
		mockSavedScore.setId(UUID.randomUUID());
		mockSavedScore.setUserId(userId);
		mockSavedScore.setEmail(request.getEmail());
		mockSavedScore.setPlayerName(request.getPlayerName());
		mockSavedScore.setScoreValue(request.getScoreValue());

		when(scoreRepository.save(any(Score.class))).thenReturn(mockSavedScore);

		// Act (Ação)
		Score result = scoreService.saveScore(request, userId);

		// Assert (Verificação)
		assertThat(result).isNotNull();
		assertThat(result.getPlayerName()).isEqualTo("Nuno");
		assertThat(result.getScoreValue()).isEqualTo(1500);
		assertThat(result.getUserId()).isEqualTo(userId);

		verify(scoreRepository, times(1)).save(any(Score.class));
	}

	@Test
	void shouldReturnTopScores() {
		// Arrange
		Score score1 = new Score();
		score1.setPlayerName("Top Player");
		score1.setScoreValue(5000);

		when(scoreRepository.findTop10ByOrderByScoreValueDesc()).thenReturn(List.of(score1));

		// Act
		Collection<ScoreResponse> scores = scoreService.getTopScores();

		// Assert
		assertThat(scores).hasSize(1);
		assertThat(scores)
			.first()
			.extracting(ScoreResponse::getScoreValue)
			.isEqualTo(5000);

		verify(scoreRepository, times(1)).findTop10ByOrderByScoreValueDesc();
	}
}
