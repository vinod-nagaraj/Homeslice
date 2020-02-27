package com.foodie.homeslice.dto;

import java.util.List;

public class ItemsResponseDto {

	private Integer statusCode;
	private String message;
	public List<ItemDetails> itemDetails;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ItemDetails> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}

}
