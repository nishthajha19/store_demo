package com.example.store.model;

import java.time.LocalDate;
import java.util.UUID;

public class Store {

	private UUID storeId;

	private String postCode;

	private String city;

	private String address;

	private LocalDate openedDate;
	
	public Store(UUID storeId,String postCode,String city,String address,LocalDate openedDate) {
        this.storeId=storeId;
        this.postCode=postCode;
        this.city=city;
        this.address=address;
        this.openedDate=openedDate;
	}

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(LocalDate openedDate) {
		this.openedDate = openedDate;
	}

	
	
	
	
	
	
	
	
	
}
