package com.foodie.homeslice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.foodie.homeslice.util.HomeSliceEnum.Priority;

@Entity
public class Preference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long preferenceId;
	private Long itemId;
	private Integer count;
	private Long customerId;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	public Long getPreferenceId() {
		return preferenceId;
	}
	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	

}
