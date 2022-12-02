package com.gxts.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gxts.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
//	@Query("FROM MOVIE WHERE MOVIENAME=?")
	public Movie findByMovieName(String movieName);

}
