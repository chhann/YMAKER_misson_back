package com.project.mission1.controller;

import com.project.mission1.dto.user.SearchUserReqDto;
import com.project.mission1.dto.user.UserReqDto;
import com.project.mission1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/information")
    public ResponseEntity<?> findUser(SearchUserReqDto searchUserReqDto) {
        System.out.println(searchUserReqDto);
        return ResponseEntity.ok(userService.getUser(searchUserReqDto));
    }

    @PostMapping("/information")
    public ResponseEntity<?> addUser(@RequestBody UserReqDto userRequestDto) {
        userService.insertUser(userRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @DeleteMapping("/information")
    public ResponseEntity<?> deleteUser(@RequestBody List<Integer> userIds) {
        userService.deleteUsers(userIds);
        return ResponseEntity.created(null).body(true);
    }


}
