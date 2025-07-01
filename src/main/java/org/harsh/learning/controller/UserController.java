package org.harsh.learning.controller;

import lombok.RequiredArgsConstructor;
import org.harsh.learning.model.LoginResponse;
import org.harsh.learning.model.ApplyResponse;
import org.harsh.learning.model.ModifyResponse;
import org.harsh.learning.model.UserResponse;
import org.harsh.learning.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{userid}")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@PathVariable("userid") int userId){
        return ResponseEntity.ok(userService.login(userId));
    }
    @PostMapping("/apply")
    public ResponseEntity<ApplyResponse> apply(@PathVariable("userid") int userId){
        return ResponseEntity.ok(userService.apply(userId));
    }

    @PutMapping("/modify")
    public ResponseEntity<ModifyResponse> modify(@RequestBody final UserResponse userResponse, @PathVariable("userid") int userId){
        userService.user(userId, userResponse);
        return ResponseEntity.ok(userService.modify(userId));
    }

}
