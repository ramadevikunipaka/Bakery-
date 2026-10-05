package com.homebakery.service;
import com.homebakery.model.Product;
import com.homebakery.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo){this.repo=repo;}
    public List<Product> all(){return repo.findAll();}
    public Product get(Long id){return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));}
    public Product save(Product p){return repo.save(p);}
}
