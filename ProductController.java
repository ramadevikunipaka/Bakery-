package com.homebakery.controller;
import com.homebakery.model.Product;
import com.homebakery.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="http://localhost:5173")
public class ProductController {
    private final ProductService service; public ProductController(ProductService service){this.service=service;}
    @GetMapping public List<Product> all(){return service.all();}
    @GetMapping("/{id}") public Product get(@PathVariable Long id){return service.get(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Product create(@Valid @RequestBody Product p){return service.save(p);}
}
