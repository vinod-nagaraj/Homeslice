package com.foodie.homeslice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.foodie.homeslice.dto.ItemDetails;
import com.foodie.homeslice.dto.ItemsResponseDto;
import com.foodie.homeslice.entity.Item;
import com.foodie.homeslice.entity.Preference;
import com.foodie.homeslice.exception.NoItemAvailableException;
import com.foodie.homeslice.repository.CategoryRepository;
import com.foodie.homeslice.repository.ItemRepository;
import com.foodie.homeslice.repository.PreferenceRepository;
import com.foodie.homeslice.util.HomeSliceEnum.Priority;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PreferenceRepository preferenceRepository;

	@Override
	public ItemsResponseDto getAllItems() {
		List<Item> items = itemRepository.findAll();
		if (items.isEmpty()) {
			throw new NoItemAvailableException("");
		}
		
		List<ItemDetails> listofitems = new ArrayList<>();
		ItemsResponseDto itemResponseDto = new ItemsResponseDto();
		items.forEach(item -> {
			com.foodie.homeslice.entity.Category category = categoryRepository.findById(item.getCategoryId()).get();
			Preference preference = preferenceRepository.findByItemId(item.getItemId());
			
			ItemDetails itemdetails = new ItemDetails();
			itemdetails.setCategory(category.getCategoryName().toString());
			if (preference.getPriority().equals(Priority.HIGH)) {
				itemdetails.setFavourite(true);
			}
			{
				itemdetails.setFavourite(false);
			}
			itemdetails.setItemId(item.getItemId());
			itemdetails.setItemName(item.getItemName());
			itemdetails.setPrice(item.getPrice());
			listofitems.add(itemdetails);
			itemResponseDto.setItemDetails(listofitems);
			itemResponseDto.setMessage("Categorized List");
			itemResponseDto.setStatusCode(HttpStatus.ACCEPTED.value());

		});

		return itemResponseDto;
	}

}
