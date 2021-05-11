package com.cpe.card.card.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cpe.card.card.dto.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

	List<Card> findAll();
	
	Optional<Card> findById(int id);
	
}
