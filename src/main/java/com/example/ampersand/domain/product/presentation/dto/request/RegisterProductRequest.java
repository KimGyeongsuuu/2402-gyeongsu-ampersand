package com.example.ampersand.domain.product.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class RegisterProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String content;

    @NotNull
    private Long price;

}
