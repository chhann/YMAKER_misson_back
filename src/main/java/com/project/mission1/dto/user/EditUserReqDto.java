package com.project.mission1.dto.user;

import com.project.mission1.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
public class EditUserReqDto {
    private int userId;
    private String username;
    private String name;
    private String gender;
    private int countryId;
    private int cityId;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userName(username)
                .name(name)
                .gender(gender)
                .countryId(countryId)
                .cityId(cityId)
                .build();
    }
}
