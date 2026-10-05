package com.homebakery.service;

import com.homebakery.dto.CreateOrderRequest;
import com.homebakery.model.*;
import com.homebakery.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo; private final ProductService productService;
    public OrderService(OrderRepository orderRepo, ProductService productService){this.orderRepo=orderRepo;this.productService=productService;}
    public BakeryOrder create(CreateOrderRequest r){
        Product p=productService.get(r.getProductId());
        if(!p.isAvailable()) throw new IllegalArgumentException("Product is not available");
        BakeryOrder o=new BakeryOrder();
        o.setCustomerName(r.getCustomerName()); o.setContactNumber(r.getContactNumber());
        o.setDeliveryAddress(r.getDeliveryAddress()); o.setDeliveryDate(r.getDeliveryDate());
        o.setCustomization(r.getCustomization()); o.setProductId(p.getId()); o.setProductName(p.getName());
        o.setQuantity(r.getQuantity()); o.setTotalAmount(p.getPrice()*r.getQuantity()); o.setStatus(OrderStatus.PENDING);
        return orderRepo.save(o);
    }
    public List<BakeryOrder> all(){return orderRepo.findAll();}
    public BakeryOrder get(Long id){return orderRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));}
    public BakeryOrder status(Long id, OrderStatus status){BakeryOrder o=get(id);o.setStatus(status);return orderRepo.save(o);}
}
