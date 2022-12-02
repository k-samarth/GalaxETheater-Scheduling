package com.gxts.Model;



import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonFormat;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
/*Schedule table in the database that store all the schedule information in it*/
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*scheduleId id the unique and not null value that is generated automatically in the database that is not given by the admin*/
    private int scheduleId;
    /*scheduleCode is the unique code that refers a particular Schedule*/
    private String scheduleCode;
    /*scheduleName is specifing the schedule name like Morning,Matinee,FirstShow,SecondShow*/
    private String scheduleName;
    /*startDate is starting date of the movie in the theater*/
    private LocalDate startDate;
    /*endDate is the date on which movie schedule ends*/
    private LocalDate endDate;
    /*Time at which schedule starts*/
    private String time;
    /*To which theater schedules are going to be written by an admin*/
    private String theatreName;
    /*To which movie admin can write the schedule*/
    private String movieName;
    /*Constructor which is used in unit testing whether data is storing or not perfectly in the database  table*/
    public Schedule(String scheduleCode, String scheduleName, LocalDate startDate, LocalDate endDate, String time,
            String theatreName, String movieName) {
        super();
        this.scheduleCode = scheduleCode;
        this.scheduleName = scheduleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.theatreName = theatreName;
        this.movieName = movieName;
    }
    
    



}

