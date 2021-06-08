package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import pojo.User;


@RequestMapping(value = LoginRest.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public interface LoginRest {

	public static final String BASE_URL = "";
	public static final String LOGIN_USER_URL = "/login";
	public static final String LOGOUT_USER_URL = "/logout";
    
    @RequestMapping(
    		value = LOGIN_USER_URL,
    		method = RequestMethod.POST
    )
    ResponseEntity<UserGetDTO> login(@RequestBody UserLoginDTO userLogin);
    
    
    @RequestMapping(
    		value = LOGOUT_USER_URL,
    		method = RequestMethod.GET
    )
    ResponseEntity<HttpStatus> logout();
    
}

