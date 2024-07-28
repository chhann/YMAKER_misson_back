package com.project.mission1.repository;

import com.project.mission1.entity.City;
import com.project.mission1.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionMapper {
    public List<Country> findCountry();
    public List<City> findCity(@Param("selectCountryId") int selectCountryId);
}
