package com.ozerutkualtun.ngs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class FeignServices {


    @FeignClient(name = "scientists-service-client", url = "${scientist.service.prefix}")
    public interface ScientistServiceClient {

        @GetMapping("/api/v1/scientists/random")
        String getRandomScientistsName();
    }

    @FeignClient(name = "animals-service-client", url = "${animal.service.prefix}")
    public interface AnimalServiceClient {

        @GetMapping("/api/v1/animals/random")
        String getRandomAnimalName();
    }



}
