package utils;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;

/**
 * 
 * @author Gouy Quentin
 *  Class MapStructMapperImpl
 *  Implementation de l'inteface MapStructMapper
 */
public class MapStructMapperImpl implements MapStructMapper {

	/**
	 * Transformation du userDTO vers user entité base de données
	 * @param userDTO user à transformer
	 * @return User entité base de données
	 */
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
		
		return user;
	}

	/**
	 * Transformation d'un user entité vers user DTO 
	 * @param user user à transformer
	 * @return UserGetDTO classe manipulée côté front
	 */
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
	
	public MapStructMapperImpl() {
		
	}
}
