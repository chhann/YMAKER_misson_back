package com.project.mission1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityRegister {
    private int cityRegisterId;
    private int userId;
    private int cityId;
    private String cityName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
