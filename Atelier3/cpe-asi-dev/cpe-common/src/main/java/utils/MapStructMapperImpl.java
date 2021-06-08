package utils;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.User;

public class MapStructMapperImpl implements MapStructMapper {

	public User userPostDTOtoUser(UserPostDTO userDTO) {
		if(userDTO == null) {
			return null;
		}
		
		User user = new User();
		
		user.setUserId(null);
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setPassword(userDTO.getPassword());
		user.setMoney(0);
		user.setCards(null);
		
		return user;
	}

	public UserGetDTO userToUserGetDTO(User user) {
		if(user == null) {
			return null;
		}
		
		UserGetDTO userMapp = new UserGetDTO();
		
		userMapp.setId(user.getUserId());
		userMapp.setSurname(user.getSurname());
		userMapp.setMoney(user.getMoney());
		
		return userMapp;
	}
	
}
