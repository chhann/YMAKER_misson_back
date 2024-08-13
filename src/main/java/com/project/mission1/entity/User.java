package com.project.mission1.entity;

import com.project.mission1.dto.city.SelectedCities;
import com.project.mission1.dto.user.SearchUserRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private List<CityRegister> cityRegisters;

    public List<SelectedCities> toSelectedCity() {
        List<SelectedCities> selectedCitiesList = new ArrayList<>();

        for(CityRegister cityRegister : cityRegisters) {
            SelectedCities selectedCity = new SelectedCities();
            selectedCity.setCityId(cityRegister.getCityId());
            selectedCity.setCityName(cityRegister.getCityName());

            selectedCitiesList.add(selectedCity);
        }
        return selectedCitiesList;
    }

    public SearchUserRespDto toRespDto() {
        return SearchUserRespDto.builder()
                .userId(userId)
                .userName(userName)
                .name(name)
                .gender(gender)
                .countryId(countryId)
                .countryName(countryName)
                .selectedCities(toSelectedCity())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
