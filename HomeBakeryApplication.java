package com.homebakery;

import com.homebakery.model.Product;
import com.homebakery.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeBakeryApplication {
    public static void main(String[] args) { SpringApplication.run(HomeBakeryApplication.class, args); }

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Product(null, "Chocolate Cake", "Rich chocolate cake", 600.0, "Cakes", true));
                repository.save(new Product(null, "Red Velvet Cake", "Soft red velvet cake with cream cheese frosting", 750.0, "Cakes", true));
                repository.save(new Product(null, "Brownie Box", "Box of 6 chocolate brownies", 300.0, "Brownies", true));
                repository.save(new Product(null, "Vanilla Cupcakes", "Box of 6 vanilla cupcakes", 350.0, "Cupcakes", true));
                repository.save(new Product(null, "Butter Cookies", "Homemade butter cookies", 250.0, "Cookies", true));
            }
        };
    }
}
