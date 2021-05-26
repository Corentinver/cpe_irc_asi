package com.cpe.card.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cpe.card.card.pojo.Affinity;

public interface AffinityRepository extends JpaRepository<Affinity, Long>{

}

