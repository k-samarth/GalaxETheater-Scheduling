package com.gxts.service.Implementation;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxts.Model.Theatre;
import com.gxts.Repository.TheatreRepository;
import com.gxts.service.TheatreService;
@Service
public class TheatreServiceImplementation implements TheatreService{
	@Autowired
	TheatreRepository repository;

	@Override
	public Theatre addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return repository.save(theatre);
	}

	@Override
	public Theatre updateTheatre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theatre findByTheatreName(String theatreName) {
		return repository.findByTheatreName(theatreName);
	}

	@Override
	public boolean isTheatreExists(String theatreName) {
		Theatre t=findByTheatreName(theatreName);
//		int a=t.getTheatreId();
//		Optional<Theatre> theatre=repository.findById(a);
//		return theatre.isPresent();
		if(t==null)
			return false;
		else
			return true;
	}

	@Override
	public Theatre findByTheatreName1(String theatreName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
