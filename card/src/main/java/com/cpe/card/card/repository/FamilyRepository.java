package com.cpe.card.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cpe.card.card.pojo.Family;

public interface FamilyRepository extends JpaRepository<Family, Long>{

}
