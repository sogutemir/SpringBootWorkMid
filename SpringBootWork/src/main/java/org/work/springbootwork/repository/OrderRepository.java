package org.work.springbootwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springbootwork.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
