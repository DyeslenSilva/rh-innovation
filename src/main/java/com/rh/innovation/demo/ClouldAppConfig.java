package com.rh.innovation.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ClouldAppConfig {

	public static void main(String[] args) {
		SpringApplication.run(ClouldAppConfig.class, args);
	}

}
