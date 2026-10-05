package com.homebakery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class BakeryOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String customerName;
    @NotBlank @Pattern(regexp="^[0-9+() -]{7,20}$", message="Enter a valid contact number") private String contactNumber;
    @NotBlank private String deliveryAddress;
    @NotNull @FutureOrPresent private LocalDate deliveryDate;
    private String customization;
    @NotNull private Long productId;
    @NotBlank private String productName;
    @Positive private int quantity;
    @Positive private double totalAmount;
    @Enumerated(EnumType.STRING) private OrderStatus status = OrderStatus.PENDING;

    public BakeryOrder() {}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getContactNumber(){return contactNumber;} public void setContactNumber(String v){contactNumber=v;}
    public String getDeliveryAddress(){return deliveryAddress;} public void setDeliveryAddress(String v){deliveryAddress=v;}
    public LocalDate getDeliveryDate(){return deliveryDate;} public void setDeliveryDate(LocalDate v){deliveryDate=v;}
    public String getCustomization(){return customization;} public void setCustomization(String v){customization=v;}
    public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
    public String getProductName(){return productName;} public void setProductName(String v){productName=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
    public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double v){totalAmount=v;}
    public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;}
}
