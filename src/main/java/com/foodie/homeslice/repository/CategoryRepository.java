package com.foodie.homeslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.homeslice.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
