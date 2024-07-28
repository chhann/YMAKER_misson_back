package com.project.mission1.dto.city;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityRespDto {
    private int cityId;
    private int countryId;
    private String cityName;
}
