package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.requests.ProductRequestDTO;
import com.projeto.ecommerce.responses.ProductResponseDTO;
import com.projeto.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){this.productService = productService;}

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO prodReq){
        ProductResponseDTO prodRes =  productService.createProduct(prodReq);
        return ResponseEntity.ok(prodRes);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<ProductResponseDTO> showById(@PathVariable UUID id){
        ProductResponseDTO productDTO = productService.showProductById(id);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@Valid @PathVariable UUID id, @RequestBody ProductRequestDTO prodReq){
        ProductResponseDTO updatedProduct = productService.updateProduct(id, prodReq);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("produto deletado com sucesso!");
    }
}
