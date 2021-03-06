package com.stackroute.juggler.ticketengine.service;

import java.text.ParseException;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.ticketengine.domain.Show;

public interface ShowService {

	public Show getById(String showId);
	
	public Iterable<Show> getAll();
	
//	public Show save(Show show);
	
	public Show updateBlocked(Show show);
	
	public Show updateBooked(Show show);
	
	public void delete(String showId);
	
	public void getDetails(MovieSchedule movieSchedule) throws ParseException;
	
//	public void getBookedSeats(TicketDetails ticketDetails);
	
}
