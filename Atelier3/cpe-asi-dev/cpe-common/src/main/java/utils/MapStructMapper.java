package utils;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.User;

public interface MapStructMapper {
	public User userPostDTOtoUser(UserPostDTO user);
	public UserGetDTO userToUserGetDTO(User user);
}
