package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.UserDTO;

@Service
public class UserDAO {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Value("${user_ms_address}")
	public String userURL;
	
	public void getX() {
		ResponseEntity<String> response
		  = restTemplate.getForEntity(userURL, String.class);
		return;
	}

}
