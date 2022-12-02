package com.gxts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxts.Model.Movie;
import com.gxts.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired(required=false)
	MovieService movieService;
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	@GetMapping("{movieName}")
	public Movie findByMovie(@PathVariable("movieName")String movieName) {
		return movieService.findByMovieName(movieName);
	}

}
