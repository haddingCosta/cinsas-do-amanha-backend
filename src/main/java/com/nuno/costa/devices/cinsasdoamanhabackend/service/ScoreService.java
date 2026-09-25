package com.nuno.costa.devices.cinsasdoamanhabackend.service;

import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreRequest;
import com.nuno.costa.devices.cinsasdoamanhabackend.mapper.ScoreMapper;
import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import com.nuno.costa.devices.cinsasdoamanhabackend.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository scoreRepository;

	public Score saveScore(ScoreRequest request, String userId) {
		Score score = ScoreMapper.toEntity(request, userId);
		return scoreRepository.save(score);
	}

	public List<Score> getTopScores() {
		return scoreRepository.findTop10ByOrderByScoreValueDesc();
	}
}
