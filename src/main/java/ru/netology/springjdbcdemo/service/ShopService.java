package ru.netology.springjdbcdemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springjdbcdemo.exception.EmptyResultDataException;
import ru.netology.springjdbcdemo.exception.InvalidCredentials;
import ru.netology.springjdbcdemo.repository.ShopRepository;

import java.util.List;

@Service
public class ShopService {
    ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<String> getProductName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCredentials("Customer name is empty");
        }
        List<String> products = shopRepository.getProductName(name);
        if (products.isEmpty()) {
            throw new EmptyResultDataException("Product names are not found");
        } else {
            return products;
        }
    }
}
