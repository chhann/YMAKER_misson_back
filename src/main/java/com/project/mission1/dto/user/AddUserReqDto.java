package com.project.mission1.dto.user;

import com.project.mission1.entity.CityRegister;
import com.project.mission1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddUserReqDto {
    private String username;
    private String name;
    private String gender;
    private int country;

    private List<AddUserCitiesReqDto> cities;

    // 선택된 도시들(최대 2개) 도시 아이디만 있는 list 만들기
    public List<CityRegister> toCityRegister(int userId) {
        List<CityRegister> cityRegisters = new ArrayList<>();

        for(AddUserCitiesReqDto addUserCitiesReqDto : cities) {
            CityRegister cityRegister = CityRegister.builder()
                    .userId(userId)
                    .cityId(addUserCitiesReqDto.getCityId())
                    .cityName(addUserCitiesReqDto.getCityName())
                    .build();

            cityRegisters.add(cityRegister);
        }

        return cityRegisters;
    };



    public User toEntity() {
        return User.builder()
                .userName(username)
                .name(name)
                .gender(gender)
                .countryId(country)
                .build();
    }
}
