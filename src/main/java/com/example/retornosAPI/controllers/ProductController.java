package com.example.retornosAPI.controllers;

import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.services.ProductService;
import com.example.retornosAPI.validator.ProductValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    private final ProductValidator productValidator;

    public ProductController(ProductService service, ProductValidator productValidator) {
        this.service = service;
        this.productValidator = productValidator;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid Product product, BindingResult result) {
        // Validando o produto
        productValidator.validate(product, result);

        // Se houver erros de validação, retornar uma resposta com os erros
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            return ResponseEntity.badRequest().body(errors.toString());
        }

        return ResponseEntity.ok(service.createProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
