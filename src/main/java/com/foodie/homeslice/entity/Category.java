package com.foodie.homeslice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.foodie.homeslice.util.HomeSliceEnum.CategoryName;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	@Enumerated(EnumType.STRING)
	private CategoryName categoryName;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryName getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(CategoryName categoryName) {
		this.categoryName = categoryName;
	}


}
