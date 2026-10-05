package com.homebakery.controller;
import com.homebakery.dto.*;
import com.homebakery.model.BakeryOrder;
import com.homebakery.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins="http://localhost:5173")
public class OrderController {
    private final OrderService service; public OrderController(OrderService service){this.service=service;}
    @GetMapping public List<BakeryOrder> all(){return service.all();}
    @GetMapping("/{id}") public BakeryOrder get(@PathVariable Long id){return service.get(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public BakeryOrder create(@Valid @RequestBody CreateOrderRequest request){return service.create(request);}
    @PutMapping("/{id}/status") public BakeryOrder status(@PathVariable Long id,@Valid @RequestBody StatusRequest request){return service.status(id,request.getStatus());}
}
