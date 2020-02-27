package com.foodie.homeslice.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PreferenceReposnseDto {

	private Integer statuscode;
	private String message;
	private List<Favourite> favourites;
	private List<Like> likes;
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Favourite> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<Favourite> favourites) {
		this.favourites = favourites;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	
}
