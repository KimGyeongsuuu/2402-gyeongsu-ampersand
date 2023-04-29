package com.example.ampersand.domain.product.presentation;


import com.example.ampersand.domain.product.presentation.dto.request.RegisterProductRequest;
import com.example.ampersand.domain.product.presentation.dto.response.GetDetailProductResponse;
import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;
import com.example.ampersand.domain.product.service.GetDetailProductService;
import com.example.ampersand.domain.product.service.GetProductService;
import com.example.ampersand.domain.product.service.RegisterProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final RegisterProductService registerProductService;
    private final GetProductService getProductService;
    private final GetDetailProductService getDetailProductService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProduct(@RequestBody @Valid RegisterProductRequest registerProductRequest){
        registerProductService.execute(registerProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<GetProductResponse>> viewProduct(){
        List<GetProductResponse> products = getProductService.execute();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<GetDetailProductResponse> viewDetailProduct(@PathVariable Long product_id){
        GetDetailProductResponse product = getDetailProductService.execute(product_id);
        return ResponseEntity.ok(product);
    }

}
