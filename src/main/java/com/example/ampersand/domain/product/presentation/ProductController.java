package com.example.ampersand.domain.product.presentation;


import com.example.ampersand.domain.product.presentation.dto.request.RegisterRequest;
import com.example.ampersand.domain.product.service.RegisterProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final RegisterProductService registerProductService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProduct(@RequestBody @Valid RegisterRequest registerRequest){
        registerProductService.execute(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}