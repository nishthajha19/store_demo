package com.example.store.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.store.dto.StoreDTO;
import com.example.store.model.Store;
import com.example.store.utils.CommonUtils;
import com.opencsv.CSVReader;

@Service
public class StoreService {

	public ResponseEntity<List<Store>> getStoreList(StoreDTO storeDTO) {
		List<String[]> list;
		List<Store> storeList = null;
		try {
			list = CommonUtils.readCSV("store.csv");
			list.remove(0);
			storeList = new ArrayList<>();
			for (String[] strArr : list) {
				Store store = new Store(UUID.fromString(strArr[0]), strArr[1], strArr[2], strArr[3],
						getFromString(strArr[4]));
				storeList.add(store);
			}
			if(storeDTO.getFilter().equalsIgnoreCase("city")){
				storeList.sort(Comparator.comparing(Store::getCity));
			} else if(storeDTO.getFilter().equalsIgnoreCase("openeddate")){
				storeList.sort(Comparator.comparing(Store::getOpenedDate));
			} 
		} catch (IOException e) {
			new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (URISyntaxException e) {
			new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}

	private LocalDate getFromString(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return LocalDate.parse(dateString, formatter);
	}
}
