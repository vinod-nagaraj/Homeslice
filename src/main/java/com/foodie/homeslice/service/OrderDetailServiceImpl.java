package com.foodie.homeslice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.foodie.homeslice.dto.OrderedListRequestDto;
import com.foodie.homeslice.entity.OrderDetail;
import com.foodie.homeslice.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	OrderDetailRepository orderDetailRepository;

	@Override
	public void placeOrder(Long customerId, OrderedListRequestDto orderedListRequestDto) {
		List<OrderDetail> list = new ArrayList<>();
		OrderDetail ordreDetail = new OrderDetail();
		ordreDetail.setCustomerId(customerId);
		ordreDetail.setDate(LocalDate.now());
		ordreDetail.getItems().addAll(orderedListRequestDto.getOrderedList());
		ordreDetail.setStatus("ordered");
		ordreDetail.setTotalPrice(orderedListRequestDto.getPrice());

		orderDetailRepository.save(ordreDetail);
		
		
	}

	
	
}
