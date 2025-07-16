package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.JsonDto;
import com.example.demo.dto.JsonMapper;
import com.example.demo.exception.InvalidException;
import com.example.demo.model.Json;


@Service
public class JsonService {
	
	private final String jsonHolder = "https://jsonplaceholder.typicode.com/posts";
	
	public List<JsonDto> getPagination(int page, int size) {
		if(page < 0 || size <= 0 ) {
			throw new InvalidException("page null ");
		}
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Json[]> resp = restTemplate.getForEntity(jsonHolder, Json[].class);
		
		if(resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null) {
			
		}
		
		List<JsonDto> getAll = Arrays.stream(resp.getBody())
				.map(JsonMapper::from)
				.collect(Collectors.toList());
		
		int start = page * size;
		int end = Math.min(start + size, getAll.size());
		
		return getAll.subList(start, end);
	}

}
