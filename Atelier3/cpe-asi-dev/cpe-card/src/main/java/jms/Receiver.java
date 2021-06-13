package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import service.CardService;

@Component
public class Receiver {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private CardService cardService;
	
	@JmsListener(destination = "queue.card.collection")
	public void sendCollectionToFront(Integer userId) {
		System.out.println("here");
		cardService.getCollectionCardsByUser(userId).forEach(card -> {
				System.out.println(card.getName());
		});
		this.template.convertAndSend("/socket/" + userId + "/shopCard", cardService.getCollectionCardsByUser(userId));
    }

    @JmsListener(destination = "queue.card.shop")
	public void sendShopToFront(Integer userId) {
    	System.out.println("here");
    	this.template.convertAndSend("/socket/" + userId + "/shopCard", cardService.getShopCardsByUser(userId));
	}
}
