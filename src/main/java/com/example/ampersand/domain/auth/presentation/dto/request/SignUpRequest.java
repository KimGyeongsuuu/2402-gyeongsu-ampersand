package com.example.ampersand.domain.auth.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
