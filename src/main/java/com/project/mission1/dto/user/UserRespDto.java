package com.project.mission1.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRespDto {
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
}
