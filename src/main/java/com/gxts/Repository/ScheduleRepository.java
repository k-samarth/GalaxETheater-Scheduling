package com.gxts.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxts.Model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	/*Getting Schedule using theater name from the Schedule table*/
	public List<Schedule> findByTheatreName(String theatreName);
	
	
	/*Getting schedules for the particular movie from the schedule table*/
	public List<Schedule> findByMovieName(String movieName);
	
	
	/*Delete all schedules for the theater using theatername from the schedule table*/
	@Modifying
	@Query("delete from Schedule u where u.theatreName = ?1")
	public void deleteSchedulesByTheatreName(String theatreName);

	/*Getting schedules from the Schedule table based on the date*/
	@Query("from Schedule u where ?1 between u.startDate and u.endDate")
	public List<Schedule> getScheduleByDate(@Param("date1") LocalDate date1);
	
	/*Getting schedules for a particular movie on specified date from schedule table*/
	@Query("from Schedule u where u.movieName=?1 and ?2 between u.startDate and u.endDate")
	public List<Schedule> getScheduleByDateMovie(@Param("movieName")String movieName, @Param("date1")LocalDate date1);
	
	/*Getting schedules for a particular theater on specified date from schedule table*/
	@Query("from Schedule u where u.theatreName=?1 and ?2 between u.startDate and u.endDate")
	public List<Schedule> getScheduleByDateTheatre(@Param("theatreName")String theatreName, @Param("date1")LocalDate date1);

	/*Getting schedules by schedule code*/
	public Schedule findByScheduleCode(String scheduleCode);
}


