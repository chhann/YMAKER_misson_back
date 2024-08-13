package com.project.mission1.controller;

import com.project.mission1.dto.user.EditUserReqDto;
import com.project.mission1.dto.user.SearchUserReqDto;
import com.project.mission1.dto.user.AddUserReqDto;
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

    // 유저 추가
    @PostMapping("/information")
    public ResponseEntity<?> addUser(@RequestBody List<AddUserReqDto> userRequestDto) {
        userService.insertUser(userRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 유저 조회
    @GetMapping("/information")
    public ResponseEntity<?> findUser(SearchUserReqDto searchUserReqDto) {
        return ResponseEntity.ok(userService.getUser(searchUserReqDto));
    }

    // 유저 변경
    @PutMapping("/information")
    public ResponseEntity<?> updateUser(@RequestBody EditUserReqDto editUserReqDto) {
        userService.updateUser(editUserReqDto);
        return ResponseEntity.created(null).body(true);
    }


    // 유저 삭제
    @DeleteMapping("/information")
    public ResponseEntity<?> deleteUser(@RequestBody List<Integer> userIds) {
        userService.deleteUsers(userIds);
        return ResponseEntity.created(null).body(true);
    }


}
