package com.ozerutkualtun.sns.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/scientists")
public class ScientistController {


    private List<String> scientists;
    private final Random random;

    public ScientistController() {

        this.random = new Random();
        try {
            InputStream inputStream = new ClassPathResource("/scientists.txt").getInputStream();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                scientists = reader.lines().collect(Collectors.toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/random")
    public String getScientistByRandom() {
        return scientists.get(random.nextInt(scientists.size()));
    }

}
