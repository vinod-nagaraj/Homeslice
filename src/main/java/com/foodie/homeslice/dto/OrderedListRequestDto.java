package com.foodie.homeslice.dto;

import java.util.List;

import com.foodie.homeslice.entity.OrderedItem;

public class OrderedListRequestDto {
	
	private List<OrderedItem> orderedList;
	private Double totalPrice;
	
	public List<OrderedItem> getOrderedList() {
		return orderedList;
	}
	public void setOrderedList(List<OrderedItem> orderedList) {
		this.orderedList = orderedList;
	}
	public Double getPrice() {
		return totalPrice;
	}
	public void setPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
