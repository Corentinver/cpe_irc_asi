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
import pojo.Room;


@RequestMapping(value = MarketRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface RoomRest {

	public static final String BASE_URL = "/room";
    public static final String CREATE_ROOM_URL = "/create";
    public static final String JOIN_ROOM_URL = "/join/{id}";
    public static final String GET_ROOM_URL = "/rooms";
    
    @RequestMapping(
    		value = CREATE_ROOM_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> createRoom(@RequestBody RoomDTO room);
    
    
    @RequestMapping(
    		value = JOIN_ROOM_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<HttpStatus> joinRoom(@PathVariable Integer roomId);
    
    @RequestMapping(
    		value = JOIN_ROOM_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<List<Room>> getRooms();
}

