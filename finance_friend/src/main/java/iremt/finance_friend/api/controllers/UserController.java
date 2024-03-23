package iremt.finance_friend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iremt.finance_friend.business.abstracts.UserService;
import iremt.finance_friend.entities.concretes.User;
import iremt.finance_friend.entities.dtos.UserRegistrationDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")


public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping("/getall")
	public List<User> getAll(){
		return this.userService.getAll();
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDto userDto) {
		User newUser = userService.registerNewUser(userDto);
		return ResponseEntity.ok(newUser);
	}


}
