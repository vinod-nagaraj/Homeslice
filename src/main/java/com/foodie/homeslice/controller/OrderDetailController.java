package com.foodie.homeslice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.homeslice.dto.OrderedListRequestDto;
import com.foodie.homeslice.dto.ResponseDto;
import com.foodie.homeslice.service.OrderDetailService;

@RestController
@RequestMapping("/homeslice")
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping("/customers/{customerId}/orders")
	public ResponseDto placeOrder(@PathVariable Long customerId ,@RequestBody OrderedListRequestDto orderedListRequestDto) {
		orderDetailService.placeOrder( customerId , orderedListRequestDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Ordered");
		responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return responseDto;
	}
}
