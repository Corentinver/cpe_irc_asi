package com.game.engine.GameEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@ComponentScan(basePackages = {"com.game.engine.config","service"})
public class GameEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameEngineApplication.class, args);
	}

}
