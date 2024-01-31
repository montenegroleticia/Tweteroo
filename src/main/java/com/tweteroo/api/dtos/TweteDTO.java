package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweteDTO {

    @NotBlank
    @Size(max = 280)
    private String text ;
}
