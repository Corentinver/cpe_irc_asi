package api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import dto.UserGetDTO;
import dto.UserLoginDTO;
import rest.LoginRest;

public class LoginImpl implements LoginRest{
	
	@Autowired
	RestTemplate restTemplate;
	
    public static final String hostMarket = "localhost:8080" + LoginRest.BASE_URL;

	public ResponseEntity<UserGetDTO> login(UserLoginDTO userLogin) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostMarket).path(LoginRest.LOGIN_USER_URL).build();
		return restTemplate.postForEntity(uriComponents.toUri(), userLogin, UserGetDTO.class);
	}

	public ResponseEntity<HttpStatus> logout() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
	    	      .scheme("http").host(hostMarket).path(LoginRest.LOGIN_USER_URL).build();
		return restTemplate.getForEntity(uriComponents.toUri(), HttpStatus.class);
	}

}
