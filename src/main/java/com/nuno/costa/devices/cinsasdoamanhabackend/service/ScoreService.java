package com.nuno.costa.devices.cinsasdoamanhabackend.service;

import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreRequest;
import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreResponse;
import com.nuno.costa.devices.cinsasdoamanhabackend.mapper.ScoreMapper;
import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import com.nuno.costa.devices.cinsasdoamanhabackend.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository scoreRepository;

	public ScoreResponse saveScore(ScoreRequest request, String userId) {
		Score score = ScoreMapper.toEntity(request, userId);
		return ScoreMapper.toResponse(scoreRepository.save(score));
	}

	public Collection<ScoreResponse> getTopScores() {
		return scoreRepository.findTop10ByOrderByScoreValueDesc().stream().map(ScoreMapper::toResponse).toList();
	}
}
