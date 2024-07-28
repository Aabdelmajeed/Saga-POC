package com.common.Ordering.repository;

import com.common.Ordering.entity.Order;
import com.common.Ordering.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
