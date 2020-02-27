package com.foodie.homeslice.dto;

public class PreferenceRequestDto {
	
	private Long itemId;
	private Boolean preference;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Boolean getPreference() {
		return preference;
	}
	public void setPreference(Boolean preference) {
		this.preference = preference;
	}

}
