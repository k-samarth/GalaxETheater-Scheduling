package com.gxts.service;

import com.gxts.Model.Theatre;

public interface TheatreService {
	public Theatre addTheatre(Theatre theatre);

	public Theatre updateTheatre();
	public Theatre findByTheatreName(String theatreName);
	public boolean isTheatreExists(String theatreName);

	Theatre findByTheatreName1(String theatreName);

}
