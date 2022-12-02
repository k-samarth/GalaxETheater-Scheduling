package com.gxts.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieCode;
	private String movieName;
	private String genre;
	private LocalDate releaseDate;
	private String cast;

}



//{
//    "movieCode":"m004",
//    "movieName":"ArjunReddy",
//    "genre":"Drama",
//    "releaseDate":"2019-11-09",
//    "cast":"Vijay"
//}
//"movieCode":"m006",
//"movieName":"RRR",
//"genre":"Drama",
//"releaseDate":"2019-11-09",
//"cast":"NTR"
