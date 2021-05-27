package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

public class SocketService {


	@Autowired
	private SimpMessageSendingOperations socketTemplate;
	
	public void sendTest() {
		socketTemplate.convertAndSend("/test", "test");
	}
}
