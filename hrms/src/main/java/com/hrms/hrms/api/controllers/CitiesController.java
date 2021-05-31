package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.CityService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.City;


@RestController
@RequestMapping("/api/city")
public class CitiesController {

	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return cityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return cityService.add(city);
	}
}
