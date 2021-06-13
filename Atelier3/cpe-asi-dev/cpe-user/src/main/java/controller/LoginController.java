package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.user.User;
import rest.LoginRest;
import service.UserService;
import utils.MapStructMapperImpl;

/**
 * 
 * @author Gouy Quentin
 * Implementation des fonctions des url du controller Login
 */
@CrossOrigin
@RestController
public class LoginController implements LoginRest{

	@Autowired
	private UserService userService;
	
	private MapStructMapperImpl mapper = new MapStructMapperImpl();
	
	/**
	 * Login d'un utilisateur et récupération de ces informations côté client
	 * @param userLogin
	 * @return UserGetDTO information utilisateur côté client 
	 */
	@Override
	public ResponseEntity<UserGetDTO> login(UserLoginDTO userLogin) {
		User user = userService.login(userLogin);
		// renvoie l'utilisateur sinon erreur non trouvé
		if (user != null) {
			return new ResponseEntity<UserGetDTO>(mapper.userToUserGetDTO(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Deconnexion d'un utilisateur
	 * @return HttpStatus si déconnecté 
	 */
	@Override
	public ResponseEntity<HttpStatus> logout() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
