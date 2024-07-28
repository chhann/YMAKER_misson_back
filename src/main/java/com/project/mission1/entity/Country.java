package com.project.mission1.entity;

import com.project.mission1.dto.country.CountryRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    private int countryId;
    private String countryName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public CountryRespDto toResp() {
        return CountryRespDto
                .builder()
                .countryId(countryId)
                .countryName(countryName)
                .build();
    }
}
