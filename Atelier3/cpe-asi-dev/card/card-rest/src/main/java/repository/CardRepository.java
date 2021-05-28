package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pojo.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	List<Card> findAll();
	
	Optional<Card> findById(int id);
	
}
