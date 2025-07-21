package cookie.controller;

import cookie.model.User;
import cookie.repository.UserRepository;
import cookie.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
	   return userService.getAllUsers();
	}
    
    @PostMapping
    public User createUser(@RequestBody User user)
    {
    	return userService.createUser(user);
    }
}