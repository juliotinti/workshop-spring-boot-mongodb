package com.juliotinti.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juliotinti.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	@RequestMapping(method=RequestMethod.GET) //é igual ao @GetMapping, garantindo o Get no postman
	public ResponseEntity<List<User>> findAll(){
		User u1 = new User("1", "Maria Brown", "maria@gmail.com");
		User u2 = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(u1, u2));
		return ResponseEntity.ok().body(list);
	}
	
}