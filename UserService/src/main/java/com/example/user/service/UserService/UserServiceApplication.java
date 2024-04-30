package com.example.user.service.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;




//FOR MAKING CLIENT MICROSERVICE INJECT DEPENDENCY 1}Spring-cloud-starter-netflix-eureka-client
//2}add at the end of</dependencies>=>dependencyManagement part 3}<spring-cloud.version>2023.0.0</spring-cloud.version>
//that is version in properties of pom-file

@SpringBootApplication
@EnableDiscoveryClient // Use @EnableDiscoveryClient for general discovery support
@EnableFeignClients
public class UserServiceApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
      @Bean
	  @LoadBalanced
	  public RestTemplate restTemplate() {
	      return new RestTemplate();
	  }

}
//WE CAN USE THIS PAGE FOR CONFIGURING @BEAN OR CAN MAKE NEW CONFIGURATION CLASS FOR IMPLIMENTING @BEAN
