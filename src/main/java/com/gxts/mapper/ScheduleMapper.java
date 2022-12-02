package com.gxts.mapper;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.gxts.dto.ScheduleDto;
import com.gxts.Model.Schedule;

@Mapper
public interface ScheduleMapper {
//	@Mapping(target="scheduleId", source="schedule.scheduleId")
	@Mapping(target="scheduleCode", source="schedule.scheduleCode")
	@Mapping(target="scheduleName", source="schedule.scheduleName")
	@Mapping(target="startDate", source="schedule.startDate")
	@Mapping(target="endDate", source="schedule.endDate")
	@Mapping(target="time", source="schedule.time")
	@Mapping(target="theatreName", source="schedule.theatreName")
	@Mapping(target="movieName", source="schedule.movieName")
	public ScheduleDto convertToDto(Schedule schedule);
	
//	@Mapping(target="scheduleId", source="scheduledto.scheduleId")
	@Mapping(target="scheduleCode", source="scheduledto.scheduleCode")
	@Mapping(target="scheduleName", source="scheduledto.scheduleName")
	@Mapping(target="startDate", source="scheduledto.startDate")
	@Mapping(target="endDate", source="scheduledto.endDate")
	@Mapping(target="time", source="scheduledto.time")
	@Mapping(target="theatreName", source="scheduledto.theatreName")
	@Mapping(target="movieName", source="scheduledto.movieName")
	public Schedule convertToEntity(ScheduleDto scheduledto);
	
}
