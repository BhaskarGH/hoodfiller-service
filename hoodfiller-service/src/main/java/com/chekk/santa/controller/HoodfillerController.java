package com.chekk.santa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chekk.santa.bean.HoodInput;
import com.chekk.santa.service.HoodFillerService;

@RestController
public class HoodfillerController {
	
	@Autowired
	HoodFillerService hoodFillerService;

	@PostMapping("/hoodfiller")
	public List<Integer> getHoodMinItems(@RequestBody HoodInput hoodInput){
		return hoodFillerService.getHoodMinItems(hoodInput);
		
		 
	}
	
	
}
