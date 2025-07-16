package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JsonDto;
import com.example.demo.service.JsonService;

@RestController
@RequestMapping("api/json")
public class JsonController {

	@Autowired
	JsonService jsonService;

	@GetMapping
	public List<JsonDto> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return jsonService.getPagination(page, size);
	}

}
