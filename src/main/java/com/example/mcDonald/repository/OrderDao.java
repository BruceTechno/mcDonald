package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

    @Query(value = "select max(order_id) from mcdonald.order_info " ,nativeQuery = true)
    public int searchMaxOrderId();
}
