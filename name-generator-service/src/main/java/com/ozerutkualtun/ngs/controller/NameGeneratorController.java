package com.ozerutkualtun.ngs.controller;

import com.ozerutkualtun.ngs.dto.ResponseDto;
import com.ozerutkualtun.ngs.service.FeignServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/names")
public class NameGeneratorController {

    private final FeignServices.AnimalServiceClient animalServiceClient;
    private final FeignServices.ScientistServiceClient scientistServiceClient;

    @Autowired
    public NameGeneratorController(FeignServices.AnimalServiceClient animalServiceClient, FeignServices.ScientistServiceClient scientistServiceClient) {
        this.animalServiceClient = animalServiceClient;
        this.scientistServiceClient = scientistServiceClient;
    }

    @GetMapping("/random")
    public ResponseEntity<ResponseDto> getRandomName() {
        return ResponseEntity.ok(new ResponseDto(animalServiceClient.getRandomAnimalName(), scientistServiceClient.getRandomScientistsName()));
    }
}
