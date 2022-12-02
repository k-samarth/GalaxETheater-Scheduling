package com.gxts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gxts.mapper.ScheduleMapper;
import com.gxts.mapper.ScheduleMapperImpl;
import com.gxts.service.Implementation.ScheduleServiceImplementation;

@SpringBootApplication
public class MovieScheduleApplication {
	static Logger log = LogManager.getLogger(MovieScheduleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MovieScheduleApplication.class, args);
		System.out.println("Galaxy Movie Theatre");
		log.info("GalxeTheatre Started");
	}
	
	@Bean
	public ScheduleMapper getScheduleMapper() {
		return new ScheduleMapperImpl();
	}

}
