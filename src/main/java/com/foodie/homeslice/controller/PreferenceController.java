package com.foodie.homeslice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodie.homeslice.constant.ApplicationConstants;
import com.foodie.homeslice.dto.Favourite;
import com.foodie.homeslice.dto.Like;
import com.foodie.homeslice.dto.PreferenceReposnseDto;
import com.foodie.homeslice.dto.PreferenceRequestDto;
import com.foodie.homeslice.dto.ResponseDto;
import com.foodie.homeslice.entity.Item;
import com.foodie.homeslice.repository.ItemRepository;
import com.foodie.homeslice.service.PreferenceService;

@RestController
@RequestMapping("/customers")
public class PreferenceController {

	@Autowired
	private PreferenceService preferenceService;

	@Autowired
	private ItemRepository itemRepository;

	ResponseDto responseDto = null;

	@PostMapping("/{customerId}/preferences")
	public ResponseEntity<ResponseDto> addPreference(@PathVariable Long customerId,
			@RequestBody PreferenceRequestDto preferenceRequestDto) {
		responseDto = preferenceService.addPreference(customerId, preferenceRequestDto);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/{customerId}/preferences")
	public ResponseEntity<PreferenceReposnseDto> getPreferences(@PathVariable Long customerId) {
		List<Favourite> favourites = getFavourites(customerId);
		List<Like> likes = getLikes(customerId);
		PreferenceReposnseDto preferenceResponseDto = new PreferenceReposnseDto();
		preferenceResponseDto.setStatuscode(ApplicationConstants.SUCCESS_CODE);
		preferenceResponseDto.setMessage("Preferences retrieved successfully");
		preferenceResponseDto.setFavourites(favourites);
		preferenceResponseDto.setLikes(likes);
		return new ResponseEntity<PreferenceReposnseDto>(preferenceResponseDto, HttpStatus.OK);
	}

	public List<Favourite> getFavourites(Long customerId) {
		List<Long> preferences = preferenceService.getFavourites(customerId);
		List<Favourite> favourites = new ArrayList<>();

		preferences.forEach(itemId -> {
			Favourite favourite = new Favourite();
			Item item = itemRepository.findById(itemId).get();
			favourite.setItemId(itemId);
			favourite.setItemName(item.getItemName());
			favourite.setPrice(item.getPrice());
			favourites.add(favourite);
		});
		return favourites;
	}

	public List<Like> getLikes(Long customerId) {
		List<Long> preferences = preferenceService.getLikes(customerId);
		List<Like> likes = new ArrayList<>();

		preferences.forEach(itemId -> {
			Like like = new Like();
			Item item = itemRepository.findById(itemId).get();
			like.setItemId(itemId);
			like.setItemName(item.getItemName());
			like.setPrice(item.getPrice());
			likes.add(like);
		});
		return likes;
	}

}
