package com.ozerutkualtun.ans.controller;

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
@RequestMapping("api/v1/animals")
public class AnimalsController {

    private List<String> animalNames;
    private final Random random;

    public AnimalsController() {
        this.random = new Random();

        try {
            InputStream inputStream = new ClassPathResource("/animals.txt").getInputStream();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                animalNames = reader.lines().collect(Collectors.toList());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/random")
    public String getAnimalName() {
        return animalNames.get(random.nextInt(animalNames.size()));
    }
}
