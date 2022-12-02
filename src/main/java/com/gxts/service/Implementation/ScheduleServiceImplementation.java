package com.gxts.service.Implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;
import com.gxts.Exceptions.MovieNotFoundException;
import com.gxts.Exceptions.ScheduleNotFoundException;
import com.gxts.Exceptions.TheatreNotFoundException;
import com.gxts.Model.Movie;
import com.gxts.Model.Schedule;
import com.gxts.Model.Theatre;
import com.gxts.Repository.ScheduleRepository;
import com.gxts.dto.ScheduleDto;
import com.gxts.mapper.ScheduleMapper;
import com.gxts.mapper.ScheduleMapperImpl;
import com.gxts.service.MovieService;
import com.gxts.service.ScheduleService;
import com.gxts.service.TheatreService;

@Service
@Transactional
public class ScheduleServiceImplementation implements ScheduleService {
	@Autowired
	ScheduleRepository repository;
	@Autowired
	MovieService movieService;
	@Autowired
	TheatreService theatreService;
	@Autowired(required = false)
	ScheduleMapper mapperService;
	Logger log = LogManager.getLogger(ScheduleServiceImplementation.class);
	// Logger log = LoggerFactory.getLogger(ScheduleServiceImplementation.class);

	/* Get Schedule by theater name */
	@Override
	public List<Schedule> getSchedule(String theatreName) {
		return repository.findByTheatreName(theatreName);

	}

	@Override /* Adding a Schedule to a theatre for a particular movie */
	public boolean addSchedule(Schedule schedule, String theatreName, String movieName) {
		boolean message = false;
		if (theatreService.isTheatreExists(theatreName) == true) {
			schedule.setTheatreName(theatreName);
			if (movieService.isMovieExists(movieName) == true) {
				schedule.setMovieName(movieName);
				repository.save(schedule);
				log.info("Saved Schedule Successfully");
				message = true;

			} else {/* If movie doesnot found in the movie list we should not add schedule to it */
				log.error(movieName + "Movie Does not found");
				throw new MovieNotFoundException("Movie named" + movieName + "doesnot exists");
			}
		} else {/* If theatre does not found in movie list we should not add schedule to it */
			log.error(theatreName + "Theatre Does not found");
			throw new TheatreNotFoundException("Theatre named" + theatreName + "doesnot exists");
		}
		return message;
	}

	/* Get schedule by movie name */
	@Override
	public List<Schedule> getMovieSchedule(Schedule schedule, String movieName) {
		if (movieService.isMovieExists(movieName) == true) {
			log.info("Schedule Exists");
			return repository.findByMovieName(movieName);
		} else {
			log.error("Movie named " + movieName + " does not exists");
			throw new MovieNotFoundException("Movie named" + movieName + "doesnot exists");
		}
	}

	/* Update Schedule that is exists in the schedule table */
	@Override
	public Schedule updateSchdule(Schedule schedule) {
		return repository.save(schedule);
	}

	/* Delete a particular schedule by scheduleId */
	@Override
	public boolean deleteByScheduleId(int scheduleId) {
		if (repository.existsById(scheduleId)) {
			repository.deleteById(scheduleId);
			return true;
		} else {
			throw new ScheduleNotFoundException("Requested Schedule not found");
		}

	}

	/* Get the List of Schedules in a theater for a particular movie */
	@Override
	public List<Schedule> getSchedule1(Schedule schedule, String theatreName, String movieName) {

		return null;
	}

	/* Delete all schedules for a particular theater */
	@Override
	public String deleteAllByTheatreName(String theatreName) {
		String message;
		if (theatreService.isTheatreExists(theatreName) == true) {
			repository.deleteSchedulesByTheatreName(theatreName);
			log.info("All Schedules for " + theatreName + " deleted Successfully");
			message = "Deleted Successfully";
		} else {
			throw new TheatreNotFoundException("Theatre named" + theatreName + "doesnot exists");
		}
		return message;

	}

	/* Method to get the schedules based on date */
	@Override
	public List<Schedule> getScheduleByDate(LocalDate date) {
		return repository.getScheduleByDate(date);
	}

	/* Get the schedules by date for a particular movie */
	@Override
	public List<Schedule> getScheduleByDateMovie(String movieName, LocalDate date1) {
		if (movieService.isMovieExists(movieName)) {
			return repository.getScheduleByDateMovie(movieName, date1);
		} else {
			throw new MovieNotFoundException("Movie does not exists");
		}
	}

	/* Get schedule for a theater on particular day */
	public List<Schedule> getScheduleByDateTheatre(String theatreName, LocalDate date1) {
		if (theatreService.isTheatreExists(theatreName)) {
			return repository.getScheduleByDateTheatre(theatreName, date1);
		} else {
			throw new TheatreNotFoundException("Theatre does not exists");
		}
	}

	/* Get schedule by id */
	@Override
	public Schedule getScheduleById(int id) {
		Optional<Schedule> schedule = repository.findById(id);
		return schedule.get();
	}

	/* Checking the existance of Schedule */
	@Override
	public boolean isScheduleExists(String scheduleCode) {
		boolean flag = false;
		Schedule schedule = repository.findByScheduleCode(scheduleCode);
		if (schedule == null) {
			throw new ScheduleNotFoundException("Schedule does not found");
		} else {
			flag = true;
		}
		return flag;
	}

	// List Of Schedules In DTO By Theatre Name
//  @Override
	public List<ScheduleDto> getScheduletheatreNameDto(String theatreName) {
		// TODO Auto-generated method stub
//       Theatre t=theatreService.findByTheatreName(theatreName);
//       int tId=t.getTheatreId();
		List<Schedule> schedules = repository.findByTheatreName(theatreName);
		List<ScheduleDto> scheduleDto = new ArrayList<ScheduleDto>();

		for (Schedule scheduleData : schedules) {
			scheduleDto.add(mapperService.convertToDto(scheduleData));

		}
		return scheduleDto;

	}
	
	
//  @Override
	public List<ScheduleDto> getSchedulemovieNameDto(String movieName) {
		// TODO Auto-generated method stub
//       Theatre t=theatreService.findByTheatreName(theatreName);
//       int tId=t.getTheatreId();
		List<Schedule> schedules = repository.findByMovieName(movieName);
		List<ScheduleDto> scheduleDto = new ArrayList<ScheduleDto>();

		for (Schedule scheduleData : schedules) {
			scheduleDto.add(mapperService.convertToDto(scheduleData));

		}
		return scheduleDto;

	}
	
	
	
	
	
	// List Of Schedules In DTO By Theatre Name
//  @Override
	public List<ScheduleDto> putScheduleDto(String theatreName) {
		// TODO Auto-generated method stub
//       Theatre t=theatreService.findByTheatreName(theatreName);
//       int tId=t.getTheatreId();
		List<Schedule> schedules = repository.findByTheatreName(theatreName);
		List<ScheduleDto> scheduleDto = new ArrayList<ScheduleDto>();

		for (Schedule scheduleData : schedules) {
			scheduleDto.add(mapperService.convertToDto(scheduleData));

		}
		return scheduleDto;

	}
	
	
//  @Override
	public ScheduleDto putScheduleDto(String theatreName, String movieName,Schedule schedule) {
		// TODO Auto-generated method stub
//       Theatre t=theatreService.findByTheatreName(theatreName);
//       int tId=t.getTheatreId();
		 return mapperService.convertToDto(repository.save(schedule)) ;  
		

	}


}

