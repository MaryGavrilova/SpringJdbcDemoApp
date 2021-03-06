package ru.netology.springjdbcdemo.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springjdbcdemo.exception.InvalidCredentials;
import ru.netology.springjdbcdemo.service.ShopService;

@RestController
public class ShopController {
    ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return shopService.getProductName(name);
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentials e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer name is not found in database");
    }
}
