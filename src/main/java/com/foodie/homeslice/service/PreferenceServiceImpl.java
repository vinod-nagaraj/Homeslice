package com.foodie.homeslice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.homeslice.constant.ApplicationConstants;
import com.foodie.homeslice.dto.PreferenceRequestDto;
import com.foodie.homeslice.dto.ResponseDto;
import com.foodie.homeslice.entity.Preference;
import com.foodie.homeslice.repository.PreferenceRepository;
import com.foodie.homeslice.util.HomeSliceEnum.Priority;

@Service
public class PreferenceServiceImpl implements PreferenceService {

	@Autowired
	private PreferenceRepository preferenceRepository;
	
	ResponseDto responseDto=null;
	
	@Override
	public ResponseDto addPreference(Long customerId,PreferenceRequestDto preferenceRequestDto) {
		Preference preference = new Preference();
		preference.setCount(0);
		preference.setCustomerId(customerId);
		preference.setItemId(preferenceRequestDto.getItemId());
		if(preferenceRequestDto.getPreference()== true) {
			preference.setPriority(Priority.HIGH);
		}else {
			preference.setPriority(Priority.LOW);
		}
		preferenceRepository.save(preference);
		responseDto = new ResponseDto();
		responseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		responseDto.setMessage(ApplicationConstants.PREFERENCE_SUCCESSMESSAGE);
		return responseDto;
	}

	@Override
	public List<Long> getFavourites(Long customerId) {
		List<Long> preferences=preferenceRepository.findAllByCustomerIdAndPriority(customerId, Priority.HIGH);	
		return preferences;
	}

	@Override
	public List<Long> getLikes(Long customerId) {
		List<Long> likes=preferenceRepository.findAllByCustomerIdAndPrioritySorted(customerId, Priority.LOW);
		return likes;
	}
	
	

}
