package com.ozerutkualtun.ngs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto {

    private String animalName;
    private String scientistName;

}
