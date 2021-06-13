package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pojo.user.User;

/**
 * 
 * @author Gouy Quentin
 * Interface de liaison entre la base de données et notre service
 * Interface Data access
 * Definition des fonctions de récupération spécifique dans cet inerface
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
	 * Recherche d'un utilisateur par rapport à son username
	 * @param username
	 * @return User
	 */
    @Query(" select u from User u " +
            " where u.surname = ?1")
    Optional<User> findUserWithName(String username);
    
	/**
	 * Recherche d'un utilisateur par rapport à ses informations d'utilisateurs
	 * @param surname, password
	 * @return User
	 */
    @Query(" select u from User u " +
    		" where u.surname = ?1 and u.password = ?2")
	Optional<User> findUserWithSurnameAndPassword(String surname, String password);

}