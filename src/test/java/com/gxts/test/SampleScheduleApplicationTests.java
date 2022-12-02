package com.gxts.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gxts.Exceptions.ScheduleNotFoundException;
import com.gxts.Model.Movie;
import com.gxts.Model.Schedule;
import com.gxts.Model.Theatre;
import com.gxts.Repository.ScheduleRepository;
import com.gxts.service.ScheduleService;
import com.gxts.service.Implementation.ScheduleServiceImplementation;

@SpringBootTest
class SampleApplicationTests {
	@MockBean
	ScheduleRepository repository;
	@Autowired
	ScheduleServiceImplementation scheduleService;
	/*PositiveTesting data will be stored in database*/
	@Test
	 void testAddSchedulePositive() {
		List<Schedule> schedules=new ArrayList<>();
		Schedule schedule1=new Schedule("SC101","Evening",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-11-21"),"06:00PM","Nexus","Temper");
		Schedule schedule2=new Schedule("SC102","Morning",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-11-21"),"11:30AM","Nexus","Temper");
		Schedule schedule3=new Schedule("SC103","Matinee",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-11-21"),"11:30AM","Nexus","Temper");
//		schedules.add(schedule1);
//		schedules.add(schedule2);
//		schedules.add(schedule3);
		List<Movie> movies=new ArrayList<>();
		Movie movie1=new Movie(1, "M001","Temper","Drama",LocalDate.parse("2022-11-11"),"NTR");
		Movie movie2=new Movie(1, "M002","I","Drama",LocalDate.parse("2022-11-11"),"Vikram");
		Movie movie3=new Movie(1, "M003","RRR","Drama",LocalDate.parse("2022-11-11"),"Ram Charan");
		List<Theatre> theatres=new ArrayList<>();
		Theatre theatre1=new Theatre(1,"T001","Nexus");
		Theatre theatre2=new Theatre(2,"T002","Phoenix");
		Theatre theatre3=new Theatre(3,"T003","PVR");
		when(repository.save(schedule1)).thenReturn(schedule1);
		
		scheduleService.addSchedule(schedule1, "Temper","Nexus");
		assertEquals(1,schedules.size() );
		
		
		
		
	}
	
//	/*TheatreNotFoundExceptionTesting*/
//	@Test
//	 void testAddScheduleNegative() {
//		Schedule schedule=new Schedule("SC102","Evening",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-11-21"),"11:30AM","Nexus8","Dhee");
//		String theatreName=schedule.getTheatreName();
//		String movieName=schedule.getMovieName();
//		int actual;
//		if(scheduleService.addSchedule(schedule,theatreName, movieName)==true) {
//			actual=1;
//		}
//		else {
//			actual=0;
//		}
//		assertEquals(0, actual);
//		
//	}
	
	
	/*Delete the Schedule*/
//	@Test
//	void TestGetDeleteScheduleByIdPositive() {
//		/*assertTrue is used to check the boolean true value
//		 * here when we delete an id that already exists in the database it throws true */
//		assertTrue(scheduleService.deleteByScheduleId(3));
//	}
	
	
	/*ScheduleDoesNotFoundException as we are tring to delete the schedule that doesnot present in the table*/
//	@Test
//	void TestGetDeleteScheduleByIdNegative() {
//		/*assertFalse is used to check the boolean false value
//		 * here when we delete an id that does not exists in the database it throws false */
//		int id=59;
//			assertFalse(scheduleService.deleteByScheduleId(id));
//		
//
//	}
	
	/*Executes and we can get the data of the theatre*/
//	@Test
//	void TestGetScheduleByDateTheatreNamePositive() {
//		int actual=1;
//		if(scheduleService.getScheduleByDateTheatre("Nexus",LocalDate.parse("2022-11-19"))==null) {
//			actual=0;
//		}
//		assertEquals(1, actual);
//	}
	
//	/*TheatreNotFoundException*/
//	@Test
//	void TestGetScheduleByDateTheatreNameNegative() {
//		int actual=0;
//		if(scheduleService.getScheduleByDateTheatre("Nexus7",LocalDate.parse("2022-11-19"))==null) {
//			actual=1;
//		}
//		assertEquals(1, actual);
//	}
	
	
//	@Test
//	void TestIsScheduleExistsPositive() {
//		assertTrue(scheduleService.isScheduleExists("S025"));
//	}
//	/*ScheduleNotFoundException*/
//	@Test
//	void TestIsScheduleExistsNegative() {
//		assertFalse(scheduleService.isScheduleExists("SC013"));
//	}
	
	
//	@Test
//	void TestGetScheduleByDateMovieNamePositive() {
//		int actual=1;
//		if(scheduleService.getScheduleByDateMovie("I",LocalDate.parse("2022-11-19"))==null) {
//			System.out.println(scheduleService.getScheduleByDateMovie("I",LocalDate.parse("2022-11-19")));
//			actual=0;
//		}
//		assertEquals(1, actual);
//	}
//	
//	
//	
//	
	
	
//	/*MovieNotFoundException*/
//	@Test
//	void TestGetScheduleByDateMovieNameNegative() {
//		int actual=0;
//		if(scheduleService.getScheduleByDateMovie("Bahubali",LocalDate.parse("2022-11-19"))==null) {
//			actual=1;
//		}
//		assertEquals(1, actual);
//	}
	
	
	
//	Mockito Positive ADD
	
	
	@Test
	public void testGetSchedule() {
		List<Schedule> schedules=new ArrayList<Schedule>();
		schedules.add(new Schedule(1,"SC101","Evening",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-12-12"),"11:30AM","Nexus","Temper"));
		schedules.add(new Schedule(2,"SC102","Evening",LocalDate.parse("2022-11-11"),LocalDate.parse("2022-11-21"),"11:30AM","Nexus","RRR"));
		String theatreName="Nexus";
		when(repository.findByTheatreName(theatreName)).thenReturn(schedules);
		assertEquals(2,scheduleService.getSchedule(theatreName).size());	
	}

}
