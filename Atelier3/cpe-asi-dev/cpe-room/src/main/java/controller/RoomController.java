package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dto.RoomDTO;
import pojo.room.Room;
import rest.RoomRest;

public class RoomController implements RoomRest{

	@Override
	public ResponseEntity<HttpStatus> createRoom(RoomDTO room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<HttpStatus> joinRoom(Integer userId, Integer roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Room>> getRooms() {
		// TODO Auto-generated method stub
		return null;
	}

}
