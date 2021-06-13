package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pojo.card.Card;
import pojo.room.Room;

/**
 * 
 * @author Gouy Quentin
 * Interface de liaison entre la base de données et notre service
 * Interface Data access
 * Definition des fonctions de récupération spécifique dans cet interface
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	
}
