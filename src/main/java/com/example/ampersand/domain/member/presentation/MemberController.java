package com.example.ampersand.domain.member.presentation;


import com.example.ampersand.domain.member.service.GetRegisterProductService;
import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final GetRegisterProductService getRegisterProductService;

    @GetMapping("/my-register")
    public ResponseEntity<List<GetProductResponse>> viewRegisterProduct(){
        List<GetProductResponse> products = getRegisterProductService.execute();
        return ResponseEntity.ok(products);

    }
}
