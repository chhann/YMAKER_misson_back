package com.project.mission1.entity;

import com.project.mission1.dto.user.UserRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String userName;
    private String name;
    private String gender;
    private int countryId;
    private String countryName;
    private int cityId;
    private String cityName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public UserRespDto toRespDto() {
        return UserRespDto.builder()
                .userId(userId)
                .userName(userName)
                .name(name)
                .gender(gender)
                .countryId(countryId)
                .countryName(countryName)
                .cityId(cityId)
                .cityName(cityName)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
