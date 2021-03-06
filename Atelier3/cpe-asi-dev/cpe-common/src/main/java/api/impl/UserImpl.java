package api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import dto.UserGetDTO;
import dto.UserPostDTO;
import pojo.user.User;
import rest.UserRest;
import utils.MapStructMapperImpl;

@Component
public class UserImpl implements UserRest {

	@Autowired
	RestTemplate restTemplate;

    public static final String hostUser = "localhost:8080" + UserRest.BASE_URL;
	
	public ResponseEntity<Double> addMoney(Integer userId, double amount) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.ADD_MONEY_URL).buildAndExpand(userId);
		return restTemplate.postForEntity(uriComponents.toUri(), amount, Double.class);
	}

	public ResponseEntity<Double> removeMoney(Integer userId, double amount) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.REMOVE_MONEY_URL).buildAndExpand(userId);
		return restTemplate.postForEntity(uriComponents.toUri(), amount, Double.class);
	}

	public ResponseEntity<HttpStatus> addCard(Integer userId, Integer cardId) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.ADD_CARD_URL).buildAndExpand(userId);
		return restTemplate.postForEntity(uriComponents.toUri(), cardId, HttpStatus.class);
	}

	public ResponseEntity<HttpStatus> removeCard(Integer userId, Integer cardId) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.REMOVE_CARD_URL).buildAndExpand(userId);
		return restTemplate.postForEntity(uriComponents.toUri(), cardId, HttpStatus.class);
	}

	public ResponseEntity<User> getUserById(Integer userId) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.USER_URL).buildAndExpand(userId);
		return restTemplate.getForEntity(uriComponents.toUri(), User.class);
	}

	public ResponseEntity<UserGetDTO> createUser(UserPostDTO user) {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostUser).path(UserRest.CREATE_USER_URL).build();
		return restTemplate.postForEntity(uriComponents.toUri(), user, UserGetDTO.class);
	}

}
