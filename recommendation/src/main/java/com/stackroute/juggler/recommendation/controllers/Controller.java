package com.stackroute.juggler.recommendation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.services.MovieService;

@RestController
@RequestMapping("/api/v1")
public class Controller {

	private MovieService movieService;

//private CityService cityService;
	@Autowired
	public Controller(MovieService movieService) {
		this.movieService = movieService;
	}
//@RequestMapping(value = "/genrecityage", method = RequestMethod.POST)
//public ResponseEntity<?> getByGenreAgeCity(@PathVariable String userName,@PathVariable List<String> genreNames,@PathVariable String cityName){
//	List<Movie> movies = new ArrayList<>();
//	if(genreNames!=null) {
//		for(String genreName:genreNames) {
//		movies.addAll(movieRepository.getByGenreAgeCity(userName, genreName, cityName));
//}
//	}
//	return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
//}

//@RequestMapping(value = "/save", method = RequestMethod.POST)
//public ResponseEntity<Movie> saveMovie(Movie movie) {
//	Movie savedMovie=movieService.save(movie);
//	return new ResponseEntity<Movie> (savedMovie,HttpStatus.OK);
//}	
//@RequestMapping(value = "/{genre}", method = RequestMethod.GET)
//public ResponseEntity<?> getByGenre(@PathVariable("genre") String genre){
//	List<Movie> movies = new ArrayList<>();
//	movies.addAll(movieRepository.findByGenres(genre));
//	System.out.println("Hello");
//	return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
//}

//@RequestMapping(value = "/getall", method = RequestMethod.GET)
//public ResponseEntity<?> getAllMovies(){
//	List<Movie> getAllmovies = new ArrayList<Movie>();
//    getAllmovies= (List<Movie>) movieService.findAll();
//    System.out.println("Hello");
//	return new ResponseEntity<List<Movie>>(getAllmovies,HttpStatus.OK);	
//}
	@GetMapping("/getMoviesByGenre/{genreName}")
	public ResponseEntity<?> getMoviesByGenre(@PathVariable String genreName) {
//	System.out.println("Hi");
		return new ResponseEntity<List<Movie>>(movieService.getMoviesByGenre(genreName), HttpStatus.OK);
	}

	@GetMapping("/getMoviesByCityGenre/{cityName}&{genreName}")
	public ResponseEntity<List<Movie>> getMovieByCityGenre(@PathVariable String cityName,
			@PathVariable String genreName) {
//	System.out.println("hello");
		return new ResponseEntity<List<Movie>>(movieService.getMovieByCityGenre(cityName, genreName), HttpStatus.OK);
	}

	@GetMapping("/getMoviesByCity/{cityName}")
	public ResponseEntity<?> getMoviesByCity(@PathVariable String cityName) {
//	System.out.println("city");
		return new ResponseEntity<List<Movie>>(movieService.getMoviesByCity(cityName), HttpStatus.OK);
	}

	@GetMapping("/getMoviesByCityLanguage/{cityName}&{languageName}")
	public ResponseEntity<List<Movie>> getMovieByCityLanguage(@PathVariable String cityName,
			@PathVariable String languageName) {
		System.out.println("hello");
		return new ResponseEntity<List<Movie>>(movieService.getMovieByCityLanguage(cityName, languageName),
				HttpStatus.OK);
	}

	@GetMapping("/getMoviesByCityGenreLanguage/{cityName}&{genreName}&{languageName}")
	public ResponseEntity<List<Movie>> getMovieByCityGenreLanguage(@PathVariable String cityName,
			@PathVariable String genreName, @PathVariable String languageName) {
		System.out.println("hello");
		return new ResponseEntity<List<Movie>>(
				movieService.getMovieByCityGenreLanguage(cityName, genreName, languageName), HttpStatus.OK);
	}

}