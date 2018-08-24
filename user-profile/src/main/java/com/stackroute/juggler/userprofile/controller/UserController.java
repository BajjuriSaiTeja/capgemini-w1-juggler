package com.stackroute.juggler.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;
import com.stackroute.juggler.userprofile.service.UserService;

@RequestMapping(value = "/api/v1/userProfile")
@RestController
public class UserController {

	// creating the userservice object to use the methods in it
	private UserService userService;

	// constructer
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	// This request mapping is to accept new user and save the data to database and
	// messagebus
	@RequestMapping(value = "/regestration", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws ProfileAlreadyExitsException {
		//User userobj = null;
		try {
			User userobj = userService.saveUser(user);
			return new ResponseEntity<User>(userobj, HttpStatus.CREATED);
		} catch (ProfileAlreadyExitsException m) {
			// Error handling code
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.CONFLICT);
		}
		
	}

	// This is to view the user in the database we take user id in url itself
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> viewuser(@PathVariable int userid) throws UserDoesNotExistsException {
		try {
			User userobj = userService.viewUser(userid);
			return new ResponseEntity<User>(userobj, HttpStatus.FOUND);
		} catch (UserDoesNotExistsException m) {
			// Error Handling
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}

	}

	// This is to update user initially we find the user and allow to update
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateuser(@PathVariable int userid, @RequestBody UserProfile user)
			throws UpdateFailedException, UserDoesNotExistsException {
		try {
			User userobj = userService.updateUser(userid, user);
			return new ResponseEntity<User>(userobj, HttpStatus.OK);
		} catch (UserDoesNotExistsException m) {
			// Error handling
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED);
		}

	}

}
