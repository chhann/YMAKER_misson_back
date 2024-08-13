package com.project.mission1.dto.user;

import com.project.mission1.dto.city.SelectedCities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchUserRespDto {
    private int userId;
    private String userName;
    private String name;
    private String gender;
    private int countryId;
    private String countryName;
    private List<SelectedCities> selectedCities;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
