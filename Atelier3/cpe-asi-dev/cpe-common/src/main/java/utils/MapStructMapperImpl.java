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
	 * Transformation du userDTO vers user entit� base de donn�es
	 * @param userDTO user � transformer
	 * @return User entit� base de donn�es
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
	 * Transformation d'un user entit� vers user DTO 
	 * @param user user � transformer
	 * @return UserGetDTO classe manipul�e c�t� front
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
