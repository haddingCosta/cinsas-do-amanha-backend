package com.nuno.costa.devices.cinsasdoamanhabackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ScoreRequest {
	@NotBlank(message = "O nome do jogador é obrigatório")
	private String playerName;

	@NotBlank(message = "O email do jogador é obrigatório")
	@Email(message = "O email do jogador é inválido")
	private String email;

	@Min(value = 1, message = "A pontuação tem de ser um valor positivo")
	private int scoreValue;
}
