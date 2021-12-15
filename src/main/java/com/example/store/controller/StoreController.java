package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.dto.StoreDTO;
import com.example.store.model.Store;
import com.example.store.service.StoreService;

@RestController
public class StoreController {
	
	
	@Autowired
	StoreService storeService;
	
	
	@PostMapping("/api/store/list")
	public ResponseEntity<List<Store>> getStoreList(@RequestBody StoreDTO storeDTO) {
		return storeService.getStoreList(storeDTO);
	}

}
