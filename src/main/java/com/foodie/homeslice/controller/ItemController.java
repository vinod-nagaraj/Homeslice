package com.foodie.homeslice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.homeslice.dto.ItemsResponseDto;
import com.foodie.homeslice.entity.Item;
import com.foodie.homeslice.service.ItemService;



@RestController
@RequestMapping("/homeslice")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
	public ItemsResponseDto getAllItems(){
		
		return itemService.getAllItems();
	}
	

}
