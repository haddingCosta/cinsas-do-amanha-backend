package com.nuno.costa.devices.cinsasdoamanhabackend.controller;

import com.nuno.costa.devices.cinsasdoamanhabackend.dto.ScoreRequest;
import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import com.nuno.costa.devices.cinsasdoamanhabackend.service.ScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ScoreController {

	private final ScoreService scoreService;

	@PostMapping("/saveScore")
	public ResponseEntity<Score> saveScore(
		@Valid @RequestBody ScoreRequest request, // <-- Adicionar @Valid aqui
		@AuthenticationPrincipal Jwt jwt) {

		String userId = jwt.getSubject();
		Score savedScore = 	scoreService.saveScore(request, userId);

		return ResponseEntity.ok(savedScore);
	}

	@GetMapping("/scores")
	public Collection<Score> getTopScores() {
		return scoreService.getTopScores();
	}

}
