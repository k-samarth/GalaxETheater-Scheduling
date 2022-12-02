package com.gxts.controller;
//package com.galaxeTheatreSchedule.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxts.Model.Theatre;
import com.gxts.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	@Autowired(required=false)
	TheatreService theatreService;
	@PostMapping
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		return theatreService.addTheatre(theatre);
	}
	@PutMapping("{theatreName}")
	public Theatre updateTheatre(@RequestBody Theatre theatre ) {
		return theatreService.updateTheatre();
		
	}

}
