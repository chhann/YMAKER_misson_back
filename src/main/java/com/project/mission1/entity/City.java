package com.project.mission1.entity;

import com.project.mission1.dto.city.CityRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    private int cityId;
    private int countryId;
    private String cityName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public CityRespDto toRespDto() {
        return CityRespDto.builder()
                .cityId(cityId)
                .countryId(countryId)
                .cityName(cityName)
                .build();
    }
}
