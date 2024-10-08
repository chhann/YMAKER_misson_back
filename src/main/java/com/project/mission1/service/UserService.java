package com.project.mission1.service;

import com.project.mission1.dto.user.*;
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
    public void insertUser(List<AddUserReqDto> userRequestDto) {
        List<User> users = new ArrayList<>();

        for(AddUserReqDto addUserReqDto : userRequestDto) {
            users.add(userMapper.findUserByUsername(addUserReqDto.getUsername()));
        }

        boolean duplicateResults = checkAllNull(users);

        if(!duplicateResults) {
            throw new UsernameException(Map.of("Username 오류", "이미 존재하는 아이디가 있습니다."));
        } else {
            for(AddUserReqDto addUserReqDto : userRequestDto) {
                User user = addUserReqDto.toEntity();
                userMapper.saveUser(user);
                userMapper.saveCityRegister(addUserReqDto.toCityRegister(user.getUserId()));
            }
        }
    }

    // 유저 조회
    public List<SearchUserRespDto> getUser(SearchUserReqDto searchUserReqDto) {
        int startIndex = (searchUserReqDto.getPage() - 1) * searchUserReqDto.getCount();


        List<User> userList = userMapper.findUser(
                startIndex,
                searchUserReqDto.getCount(),
                searchUserReqDto.getUserName(),
                searchUserReqDto.getName(),
                searchUserReqDto.getGender(),
                searchUserReqDto.getCountryId(),
                searchUserReqDto.getSelectedCitiesList(),
                searchUserReqDto.getStartDate(),
                searchUserReqDto.getEndDate()
        );


        return userList.stream().map(User::toRespDto).collect(Collectors.toList());
    }

    // 유저 갯수 조회
    public SearchUserCountRespDto getUserCount(SearchUserReqDto searchUserReqDto) {
        int userCount = userMapper.getUserCount(
                searchUserReqDto.getUserName(),
                searchUserReqDto.getName(),
                searchUserReqDto.getGender(),
                searchUserReqDto.getCountryId(),
                searchUserReqDto.getSelectedCitiesList(),
                searchUserReqDto.getStartDate(),
                searchUserReqDto.getEndDate()
        );
        int maxPageNumber = (int) Math.ceil(((double) userCount) / searchUserReqDto.getCount());


        return SearchUserCountRespDto.builder()
                .totalCount(userCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }

    // 유저 정보 변경
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(EditUserReqDto editUserReqDto) {
        User findUser = userMapper.findUserByUsername(editUserReqDto.getUsername());



        if(findUser != null && !findUser.getUserName().equals(editUserReqDto.getUsername())) {
            throw new UsernameException(Map.of("Username오류", "이미 존재하는 아이디가 있습니다."));
        } else {
            User user = editUserReqDto.toEntity();
            userMapper.updateUser(user);
            System.out.println(editUserReqDto.toCityRegister(user.getUserId()));
            userMapper.updateCityRegister(editUserReqDto.toCityRegister(user.getUserId()));
        }
    }


    // 유저 삭제
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsers(List<Integer> userIds) {
        userMapper.deleteUsersByUserIds(userIds);
    }

}
