package com.project.mission1.dto.user;

import com.project.mission1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserReqDto {
    private String username;
    private String name;
    private String gender;
    private int country;
    private int city;

    public User toEntity() {
        return User.builder()
                .userName(username)
                .name(name)
                .gender(gender)
                .countryId(country)
                .cityId(city)
                .build();
    }
}
