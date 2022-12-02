package com.gxts.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gxts.Model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
	public Theatre findByTheatreName(String theatreName);

	//public boolean isPresent();
}
