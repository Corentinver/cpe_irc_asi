package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dto.RoomDTO;
import pojo.room.Room;
import repository.RoomRepository;

public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Room createRoom(Room room) {
		return roomRepository.save(room);
	}

	public boolean joinRoom(Integer userId, Integer roomId) {
		Boolean result = false;
		Optional<Room> room = roomRepository.findById(roomId);
		if(room.isEmpty()) {
			room.get().addUser(userId);
			result = roomRepository.save(room.get()) != null;
		}
		
		return result;
	}

	public List<Room> getRooms() {
		return roomRepository.findAll();
	}
}
