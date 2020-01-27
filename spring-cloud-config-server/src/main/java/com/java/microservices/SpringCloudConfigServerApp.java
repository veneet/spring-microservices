package com.java.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApp.class, args);
	}

}
