package com.nuno.costa.devices.cinsasdoamanhabackend.mapper;

import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreRequest;
import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreResponse;
import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import jakarta.validation.constraints.NotNull;

public class ScoreMapper {

	private ScoreMapper() {
		// Construtor privado para evitar instanciação de uma classe utilitária
	}

	public static Score toEntity(ScoreRequest request, String userId) {
		if (request == null) {
			return null;
		}

		Score score = new Score();
		score.setUserId(userId);
		score.setEmail(request.getEmail());
		score.setPlayerName(request.getPlayerName());
		score.setScoreValue(request.getScoreValue());

		return score;
	}

	public static ScoreResponse toResponse(@NotNull Score score) {
		ScoreResponse response = new ScoreResponse();

		response.setEmail(score.getEmail());
		response.setPlayerName(score.getPlayerName());
		response.setScoreValue(score.getScoreValue());

		return response;
	}
}
