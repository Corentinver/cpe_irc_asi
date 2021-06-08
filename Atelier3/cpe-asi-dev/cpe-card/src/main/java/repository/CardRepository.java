package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pojo.card.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

	List<Card> findAll();
	
	Optional<Card> findById(int id);
	
}
