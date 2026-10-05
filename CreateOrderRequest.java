package com.homebakery.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class CreateOrderRequest {
    @NotBlank private String customerName;
    @NotBlank private String contactNumber;
    @NotBlank private String deliveryAddress;
    @NotNull @FutureOrPresent private LocalDate deliveryDate;
    private String customization;
    @NotNull private Long productId;
    @Min(1) private int quantity;
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getContactNumber(){return contactNumber;} public void setContactNumber(String v){contactNumber=v;}
    public String getDeliveryAddress(){return deliveryAddress;} public void setDeliveryAddress(String v){deliveryAddress=v;}
    public LocalDate getDeliveryDate(){return deliveryDate;} public void setDeliveryDate(LocalDate v){deliveryDate=v;}
    public String getCustomization(){return customization;} public void setCustomization(String v){customization=v;}
    public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
}
