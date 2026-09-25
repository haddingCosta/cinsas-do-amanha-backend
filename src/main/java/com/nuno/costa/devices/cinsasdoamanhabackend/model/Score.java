package com.nuno.costa.devices.cinsasdoamanhabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Temporal;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "scores")
@NoArgsConstructor
@Data
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String userId;
	@NotEmpty(message = "O wmail é obrigatorio")
	@Email(message = "Email inválido")
	private String email;
	@NotEmpty(message = "O nome é obrigatorio")
	private String playerName;
	@Positive(message = "Pontuação inválida")
	private int scoreValue;
	private LocalDateTime createdAt = LocalDateTime.now();
}
