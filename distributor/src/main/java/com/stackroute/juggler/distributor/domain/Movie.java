package com.stackroute.juggler.distributor.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

//Domain object for movie details given by the distributor
@Document
public class Movie {
	@Id
	public String id;
	private String movieName;
	private String moviePoster;
	private String[] actors;
	private String[] actress;
	private String[] directors;
	private String[] movieGenres;
	private String synopsis;
	private String format;
	private String[] languages;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime movieDuration;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate movieReleaseDate;

	public Movie() {
	}

	public Movie(String id, String movieName, String moviePoster, String[] actors, String[] actress, String[] directors,
			String[] movieGenres, String synopsis, String format, String[] languages, LocalTime movieDuration,
			LocalDate movieReleaseDate) {
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.actors = actors;
		this.actress = actress;
		this.directors = directors;
		this.movieGenres = movieGenres;
		this.synopsis = synopsis;
		this.format = format;
		this.languages = languages;
		this.movieDuration = movieDuration;
		this.movieReleaseDate = movieReleaseDate;
	}
	
	public Movie(String id, String movieName, String moviePoster, String[] actors, String[] actress, String[] directors,
			String[] movieGenres, String synopsis, String format, String[] languages, String movieDuration,
			String movieReleaseDate) {
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.actors = actors;
		this.actress = actress;
		this.directors = directors;
		this.movieGenres = movieGenres;
		this.synopsis = synopsis;
		this.format = format;
		this.languages = languages;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
		LocalDate localDate = LocalDate.parse(movieReleaseDate, formatter);
		this.movieReleaseDate = localDate;
		DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.parse(movieDuration, formattertime);
		this.movieDuration = localTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String[] getActress() {
		return actress;
	}

	public void setActress(String[] actress) {
		this.actress = actress;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public String[] getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String[] movieGenres) {
		this.movieGenres = movieGenres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public LocalTime getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(LocalTime movieDuration) {
		this.movieDuration = movieDuration;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

}
