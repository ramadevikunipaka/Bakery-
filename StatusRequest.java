package com.homebakery.dto;
import com.homebakery.model.OrderStatus;
import jakarta.validation.constraints.NotNull;
public class StatusRequest { @NotNull private OrderStatus status; public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus status){this.status=status;} }
