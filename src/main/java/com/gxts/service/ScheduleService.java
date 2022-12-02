package com.gxts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gxts.Model.Schedule;
import com.gxts.dto.ScheduleDto;
@Component
public interface ScheduleService {
	/*Get Schedule by theater name*/
	public List<Schedule> getSchedule(String theatreName);
	/*Get schedule by movie name*/
	public List<Schedule> getMovieSchedule(Schedule schedule, String movieName);
	/*Add schedule to a theater for particular movie*/
	public boolean addSchedule(Schedule schedule, String theatreName, String movieName);
	/*Update Schedule that is exists in the schedule table*/
	public Schedule updateSchdule(Schedule schedule);
	/*Delete a particular schedule by scheduleId*/
	public boolean deleteByScheduleId(int scheduleId);
	/*Get the List of Schedules in a theater for a particular movie*/
	public List<Schedule> getSchedule1(Schedule schedule, String theatreName, String movieName);
	/*Delete all schedules for a particular theater*/
	public String deleteAllByTheatreName(String theatreName);
	/*Method to get the schedules based on date*/
	public List<Schedule> getScheduleByDate(LocalDate date);
	/*Get the schedules by date for a particular movie*/
	public List<Schedule> getScheduleByDateMovie(String movieName, LocalDate date1);
	/*Get schedule by id*/
	public Schedule getScheduleById(int id);
	/*Get schedule for a theater on particular day*/
	public List<Schedule> getScheduleByDateTheatre(String theatreName, LocalDate date1);
	/*Checking the existance of schedule*/
	public boolean isScheduleExists(String scheduleCode);
//	ScheduleDto
	 public List<ScheduleDto> getScheduletheatreNameDto( String theatreName) ;
	 public List<ScheduleDto> getSchedulemovieNameDto( String movieName) ;
		public ScheduleDto putScheduleDto(String theatreName, String movieName,Schedule schedule);
	

}
