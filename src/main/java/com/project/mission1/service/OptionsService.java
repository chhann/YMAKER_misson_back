package com.project.mission1.service;

import com.project.mission1.dto.city.CityReqDto;
import com.project.mission1.dto.city.CityRespDto;
import com.project.mission1.dto.country.CountryRespDto;
import com.project.mission1.entity.City;
import com.project.mission1.entity.Country;
import com.project.mission1.repository.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionsService {

    @Autowired
    private OptionMapper optionMapper;

    // 나라 get
    public List<CountryRespDto> getCountry() {
        List<Country> countries = optionMapper.findCountry();

        return countries.stream().map(Country::toResp).collect(Collectors.toList());
    }

    // 도시 get
    public List<CityRespDto> getCity(CityReqDto cityReqDto) {
        List<City> cities = optionMapper.findCity(cityReqDto.getSelectCountryId());

        return cities.stream().map(City::toRespDto).collect(Collectors.toList());
    }



}
