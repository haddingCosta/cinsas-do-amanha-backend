package com.nuno.costa.devices.cinsasdoamanhabackend.repository;

import com.nuno.costa.devices.cinsasdoamanhabackend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {


	// Método personalizado para ir buscar o top 10 ordenado por pontuação descendente
	List<Score> findTop10ByOrderByScoreValueDesc();
}
