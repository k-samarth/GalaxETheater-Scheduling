package com.gxts.service.Implementation;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxts.Model.Movie;
import com.gxts.Model.Theatre;
import com.gxts.Repository.MovieRepository;
import com.gxts.service.MovieService;

@Service
public class MovieServiceImplementation implements MovieService{
	@Autowired
	MovieRepository movieRepository;
	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	public Movie findByMovieName(String movieName) {
		
		return movieRepository.findByMovieName(movieName);
	}
	public boolean isMovieExists(String movieName) {
		Movie m=findByMovieName(movieName);
		if(m==null)
			return false;
		else 
			return true;
//		int a=m.getMovieId();
//		Optional<Movie> movie=movieRepository.findById(a);
//		return movie.isPresent();
	}
	
	
}
