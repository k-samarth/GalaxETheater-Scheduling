package com.gxts.service;

import java.util.List;

import com.gxts.Model.Movie;

public interface MovieService {
	public Movie addMovie(Movie movie);
	public Movie findByMovieName(String movieName);
	public boolean isMovieExists(String movieName);
}
