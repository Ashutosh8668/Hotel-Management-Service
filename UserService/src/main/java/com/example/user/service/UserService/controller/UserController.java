package com.example.user.service.UserService.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.service.UserService.entities.User;
import com.example.user.service.UserService.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
//import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserService userService;
        
        private Logger logger = LoggerFactory.getLogger(UserController.class);
        
        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User user1 = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user1);
        }

        //single user get

        //we can use param or  path variable =>1}Request Parameter: 2}Path Variable:
        //here return type in circuit-breaker same as for class 
        @GetMapping("/{userId}")
        @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
       // @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
        @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
        public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
            logger.info("Get Single User Handler: UserController");
//            logger.info("Retry count: {}", retryCount);

            User user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        }

        //here the type of calling circuit-breaker same that is responseEntity
        public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
            logger.info("Fallback is executed because service is down: {}", ex.getMessage());
            ex.printStackTrace();

            User user = User.builder()
                    .userId("141234")
                    .name("Dummy")
                    .email("dummy@gmail.com")
                    .about("This user is created dummy because some service is down")
                    .build();

            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
        
        @GetMapping
        public ResponseEntity<List<User>> getAllUser() {
            List<User> allUser = userService.getAllUser();
            return ResponseEntity.ok(allUser);
        }
}
