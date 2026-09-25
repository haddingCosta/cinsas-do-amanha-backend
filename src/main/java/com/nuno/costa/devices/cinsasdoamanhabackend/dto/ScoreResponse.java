package com.nuno.costa.devices.cinsasdoamanhabackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ScoreResponse {
	private String email;
	private String playerName;
	private int scoreValue;
}
