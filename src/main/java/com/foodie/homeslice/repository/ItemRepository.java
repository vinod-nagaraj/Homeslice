package com.foodie.homeslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodie.homeslice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
