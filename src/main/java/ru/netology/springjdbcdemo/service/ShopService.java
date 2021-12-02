package ru.netology.springjdbcdemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springjdbcdemo.exception.InvalidCredentials;
import ru.netology.springjdbcdemo.repository.ShopRepository;

@Service
public class ShopService {
    ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public String getProductName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCredentials("Customer name is empty");
        }
        String productName = shopRepository.getProductName(name);
        return productName;
    }

}
