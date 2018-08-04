package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudService02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudService02Application.class, args);
	}
}
