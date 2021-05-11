package com.cpe.card.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cpe.card.card.dto.OwnedCard;

public interface OwnedCardRepository extends CrudRepository<OwnedCard, Long> {
		
	  @Query("select * from ownedcard where userid = ?1")
	  List<OwnedCard> findOwnedCard(int userid);

}
