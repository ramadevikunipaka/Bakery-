package com.homebakery.repository;
import com.homebakery.model.BakeryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<BakeryOrder, Long> {}
