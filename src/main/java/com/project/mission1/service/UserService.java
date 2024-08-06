package com.project.mission1.service;

import com.project.mission1.dto.user.EditUserReqDto;
import com.project.mission1.dto.user.SearchUserReqDto;
import com.project.mission1.dto.user.UserReqDto;
import com.project.mission1.dto.user.UserRespDto;
import com.project.mission1.entity.User;
import com.project.mission1.exception.UsernameException;
import com.project.mission1.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 유저 중복 확인
    public boolean checkAllNull(List<User> users) {
        for (User user : users) {
            if (user != null) {
                return false;
            }
        }
        return true;
    }

    // 유저 등록
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(List<UserReqDto> userRequestDto) {
        List<User> users = new ArrayList<>();

        for(UserReqDto userReqDto : userRequestDto) {
            users.add(userMapper.findUserByUsername(userReqDto.getUsername()));
        }

        boolean duplicateResults = checkAllNull(users);

        if(!duplicateResults) {
            throw new UsernameException(Map.of("Username 오류", "이미 존재하는 아이디가 있습니다."));
        } else {
            for(UserReqDto userReqDto : userRequestDto) {
                userMapper.saveUser(userReqDto.toEntity());
            }
        }
    }

    // 유저 조회
    public List<UserRespDto> getUser(SearchUserReqDto searchUserReqDto) {
        List<User> userList = userMapper.findUser(
                searchUserReqDto.getUserName(),
                searchUserReqDto.getName(),
                searchUserReqDto.getGender(),
                searchUserReqDto.getCountryId(),
                searchUserReqDto.getCityId(),
                searchUserReqDto.getStartDate(),
                searchUserReqDto.getEndDate()
        );
        System.out.println(searchUserReqDto.getUserName());
        return userList.stream().map(User::toRespDto).collect(Collectors.toList());
    }

    // 유저 정보 변경
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(EditUserReqDto editUserReqDto) {
        if(userMapper.findUserByUsername(editUserReqDto.getUsername()) != null) {
            throw new UsernameException(Map.of("Username오류", "이미 존재하는 아이디가 있습니다."));
        } else {
            userMapper.updateUser(editUserReqDto.toEntity());
        }
    }


    // 유저 삭제
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsers(List<Integer> userIds) {
        userMapper.deleteUsersByUserIds(userIds);
    }

}
