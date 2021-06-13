package rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.RoomDTO;
import pojo.room.Room;

/**
 * 
 * @author Gouy Quentin
 * Interface CarRest pour un controller Room
 * Cet interface sera implémenté par une classe sera la représentation implementé du controller Room
 */
@RequestMapping(value = MarketRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface RoomRest {

	/*
	 * Definition des url de l'API pour le controller Room
	 */
	public static final String BASE_URL = "/room";
    public static final String CREATE_ROOM_URL = "/create";
    public static final String JOIN_ROOM_URL = "/join/{id}";
    public static final String GET_ROOM_URL = "/rooms";
    
    
	/**
	 * Création d'une salle de jeu en envoyant les informations de la salle souhaitant être créé
	 * @param room
	 * @return HttpStatus création ok
	 */
    @RequestMapping(
    		value = CREATE_ROOM_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> createRoom(@RequestBody RoomDTO room);
    
	/**
	 * Action pour rejoindre une salle
	 * @param roomId
	 * @return HttpStatus accès à la room ok
	 */
    @RequestMapping(
    		value = JOIN_ROOM_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> joinRoom(@PathVariable Integer roomId);
    
	/**
	 * Récupération des salles de jeux de l'appplication
	 * @return List<Room> 
	 */
    @RequestMapping(
    		value = JOIN_ROOM_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Room>> getRooms();
}

