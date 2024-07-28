package com.project.mission1.controller;

import com.project.mission1.dto.city.CityReqDto;
import com.project.mission1.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @GetMapping("/country")
    public ResponseEntity<?> getCountry() {
        return ResponseEntity.ok(optionsService.getCountry());
    }

    @GetMapping("/city")
    public ResponseEntity<?> getCity(CityReqDto cityReqDto) {
        return ResponseEntity.ok(optionsService.getCity(cityReqDto));
    }

}
