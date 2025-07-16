package com.example.demo.dto;

import com.example.demo.model.Json;

public class JsonMapper {
	
	public static JsonDto from(Json json) {
		return new JsonDto(json.getId(), json.getTitle());
	}

}
