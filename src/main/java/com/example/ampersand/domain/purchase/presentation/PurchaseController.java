package com.example.ampersand.domain.purchase.presentation;


import com.example.ampersand.domain.purchase.service.PurchaseProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseProductService purchaseProductService;

    @GetMapping("/{product_id}")
    public ResponseEntity<Void> orderProduct(@PathVariable("product_id") Long productId){
        purchaseProductService.execute(productId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
