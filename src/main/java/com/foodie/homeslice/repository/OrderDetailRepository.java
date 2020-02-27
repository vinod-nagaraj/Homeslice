package com.foodie.homeslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.homeslice.entity.OrderDetail;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>  {

}
