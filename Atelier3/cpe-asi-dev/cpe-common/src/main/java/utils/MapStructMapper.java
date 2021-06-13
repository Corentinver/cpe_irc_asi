package utils;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;

/**
 * 
 * @author Gouy Quentin
 * Interface MapStructMapper
 * Interface pour effectuer la transformation de classe DTO vers des classes entit�s et inversement
 */
public interface MapStructMapper {
	public User userPostDTOtoUser(UserPostDTO user);
	public UserGetDTO userToUserGetDTO(User user);
}
