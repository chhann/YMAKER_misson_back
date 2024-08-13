package com.project.mission1.repository;

import com.project.mission1.dto.city.SelectedCities;
import com.project.mission1.entity.CityRegister;
import com.project.mission1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    public int saveUser(User user);
    public int saveCityRegister(List<CityRegister> cityRegisters);
    public User findUserByUsername(String username);
    public List<User> findUser(
            @Param("userName") String username,
            @Param("name") String name,
            @Param("gender") String gender,
            @Param("countryId") int countryId,
            @Param("SelectedCitiesList")List<Integer> selectedCities,
            @Param("startDate")LocalDateTime startDate,
            @Param("endDate")LocalDateTime endDate
    );
    public int updateUser(User user);

    public int deleteUsersByUserIds(List<Integer> userIds);
}
