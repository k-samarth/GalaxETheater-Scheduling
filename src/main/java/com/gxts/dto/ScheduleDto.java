package com.gxts.dto;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDto {
	
	
//	private int scheduleId;
	private String scheduleCode;
	private String scheduleName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String time;
	private String theatreName;
	private String movieName;

}
