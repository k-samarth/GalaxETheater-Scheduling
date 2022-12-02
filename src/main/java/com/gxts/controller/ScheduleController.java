package com.gxts.controller;
//package com.galaxeTheatreSchedule.Controller;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gxts.Exceptions.MovieNotFoundException;
import com.gxts.Exceptions.ScheduleNotFoundException;
import com.gxts.Exceptions.TheatreNotFoundException;
import com.gxts.Model.Schedule;
import com.gxts.dto.ScheduleDto;
import com.gxts.service.ScheduleService;
@CrossOrigin("*")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired(required=false)
	ScheduleService scheduleService;  //Autowiring Schedule Service 
	Logger log = LogManager.getLogger(ScheduleController.class);
	
	/*Add Schedule to a movie in a theater*/
	@PostMapping("/{theatreName}/{movieName}") //"localhost:8083/schedule/$theatreName/$movieName"
	public ResponseEntity<Boolean> addSchedule(@RequestBody Schedule schedule,@PathVariable("theatreName")String theatreName,@PathVariable("movieName") String movieName) {
		try {
		return new ResponseEntity<Boolean>(scheduleService.addSchedule(schedule,theatreName,movieName),HttpStatus.ACCEPTED);
		}catch(TheatreNotFoundException e) {
			log.error(e);
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		catch(MovieNotFoundException e) {
			log.error(e);
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
	}
	
	/* Getting schedules by theater name*/
	@GetMapping("/theatreSchedule/{theatreName}") //"localhost:8083/schedule/theatreSchedule/$theatreName"
	public ResponseEntity<List<Schedule>> getSchedule(@PathVariable("theatreName") String theatreName){
		try {
		return new ResponseEntity<List<Schedule>>(scheduleService.getSchedule( theatreName), HttpStatus.ACCEPTED);
		}
		catch(NullPointerException e) {
			log.error(e);
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}
	
	}
	
	
	
	
	/* Getting schedules by movie name*/
	@GetMapping("/movieSchedule/{movieName}")//"localhost:8083/schedule/movieSchedule/$movieName"
	public ResponseEntity<List<Schedule>> getMovieSchedule(Schedule schedule,@PathVariable("movieName") String movieName){
		try {
			return new ResponseEntity<List<Schedule>>(scheduleService.getMovieSchedule(schedule, movieName),HttpStatus.ACCEPTED);
		}
		catch(NullPointerException e) {
			log.error(e);
			return new ResponseEntity<List<Schedule>>(HttpStatus.BAD_REQUEST);
		}

	
	}
	/*Delete a particular schedule*/
	@DeleteMapping("{id}")            //"localhost:8083/schedule/$id"
	public void deleteSchedule(@PathVariable("id") int id) {
		scheduleService.deleteByScheduleId(id);
	}
	
	
	
	/*Getting schedule by Theater name and movie name*/
	@GetMapping("/theatreSchedule/{theatreName}/{movieName}")   //"localhost:8083/schedule/theatreSchedule/$theatreName/$movieName"
	public ResponseEntity<List<Schedule>> getSchedule1(Schedule schedule,@PathVariable("theatreName") String theatreName,@PathVariable("movieName")String movieName){
		try {
			return new ResponseEntity<List<Schedule>>( scheduleService.getSchedule1(schedule, theatreName,movieName),HttpStatus.FOUND);
		}
		catch(NullPointerException e) {
			log.error(e);
			return new ResponseEntity<List<Schedule>>(HttpStatus.NOT_FOUND);
		}

	
	}
	
	/*Delete All Schedules for a particular theater*/
	@DeleteMapping("/delete/{theatreName}")                 //"localhost:8083/schedule/delete/$theatreId"
	public ResponseEntity<String> deleteAllByTheatreName(@PathVariable("theatreName")String theatreName) {
		try {
		return new ResponseEntity<String>(scheduleService.deleteAllByTheatreName(theatreName),HttpStatus.OK);
		}
		catch(NullPointerException e) {
			log.error(e);
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	
	
	
	@GetMapping("select/date/{date1}")  //"localhost:8083/schedule/
	public ResponseEntity<List<Schedule>> getScheduleByDate(@PathVariable("date1")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date1){
		if(scheduleService.getScheduleByDate(date1)!=null) {
		return new ResponseEntity<List<Schedule>>( scheduleService.getScheduleByDate(date1),HttpStatus.OK);
		}
		else {
		return new ResponseEntity(new ScheduleNotFoundException("Schedule does not exists"),HttpStatus.BAD_REQUEST);
		}
	}
	
	/*Get schedules by movie name*/
	@GetMapping("select/date/{movieName}/{date1}") //"localhost:8083/schedule/select/date/{movieName}/{date1}"
	public List<Schedule> getScheduleByDateMovie(@PathVariable("movieName")String movieName,@PathVariable("date1")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date1){
		return scheduleService.getScheduleByDateMovie(movieName,date1);
	}
	
	
	/* Get schedules by theatre name*/
	@GetMapping("select/theatre/{theatreName}/{date1}") //"localhost:8083/schedule/select/theatre/{theatreName}/{date1}"
	public List<Schedule> getScheduleByDateTheatre(@PathVariable("theatreName")String theatreName,@PathVariable("date1")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date1){
		return scheduleService.getScheduleByDateTheatre(theatreName,date1);
	}
	
	
	/*Updating the schedule that already exists in the database*/
	@PutMapping("/update") //"localhost:8083/schedule/update"
	public Schedule updateSchedule(@RequestBody Schedule schedule) {
		return scheduleService.updateSchdule(schedule);
		
	}
	
	
	/*Get Schedule by id*/
	@GetMapping("/get/{id}") //"localhost:8083/schedule/get/{id}"
	public Schedule getData(@PathVariable("id") int id)
	{
		return scheduleService.getScheduleById(id);
		
	}
	
	@GetMapping("/getDatatheatreName/{theatreName}")
	public List<ScheduleDto> getScheduletheatreNameDto(@PathVariable("theatreName") String theatreName)
	{
		return scheduleService.getScheduletheatreNameDto(theatreName);
		
	}
	
	
	
	@GetMapping("/getDatamovieName/{movieName}")
	public List<ScheduleDto> getScheduleDto(@PathVariable("movieName") String movieName)
	{
		return scheduleService.getSchedulemovieNameDto(movieName);
		
	}
	
	@PostMapping("/post/{theatreName}/{movieName}")
	
		public ScheduleDto putScheduleDto(@PathVariable("theatreName") String theatreName,@PathVariable("movieName") String movieName,@RequestBody Schedule schedule)
		{
			return scheduleService.putScheduleDto(theatreName,movieName,schedule);
		
		}

}





