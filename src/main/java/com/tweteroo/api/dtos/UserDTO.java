package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @Size(max = 255)
    private String avatar;

    @NotBlank
    @Size(max = 100)
    private String username;
}
