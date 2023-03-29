package com.juliotinti.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juliotinti.workshopmongo.domain.User;
import com.juliotinti.workshopmongo.dto.UserDTO;
import com.juliotinti.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	@Autowired
	private UserService service; 
	
	@RequestMapping(method=RequestMethod.GET) //é igual ao @GetMapping, garantindo o Get no postman
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).toList();
		return ResponseEntity.ok().body(listDTO);
	}
	
}
