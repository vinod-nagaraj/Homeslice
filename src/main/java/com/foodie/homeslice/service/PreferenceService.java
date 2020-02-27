package com.foodie.homeslice.service;

import java.util.List;

import com.foodie.homeslice.dto.PreferenceRequestDto;
import com.foodie.homeslice.dto.ResponseDto;
import com.foodie.homeslice.entity.Preference;

public interface PreferenceService {

	ResponseDto addPreference(Long customerId, PreferenceRequestDto preferenceRequestDto);

	List<Long> getFavourites(Long customerId);

	List<Long> getLikes(Long customerId);

}
