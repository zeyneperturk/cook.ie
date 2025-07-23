package cookie.controller;

import cookie.dto.LoginRequest;
import cookie.model.User;
import cookie.repository.UserRepository;
import cookie.service.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
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
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session)
    {
    	User user = userService.getUserByEmail(loginRequest.getEmail());
    	
    	if(user == null || !user.getPassword().equals(loginRequest.getPassword()))
    	{
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    	}
    	
    	session.setAttribute("user", user);
    	return ResponseEntity.ok(user);
    }
    
    @GetMapping("/session")
    public ResponseEntity<?> getCurrentUser(HttpSession session)
    {
    	User user = (User) session.getAttribute("user");
    	if(user==null)
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
    	return ResponseEntity.ok("user");
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session)
    {
    	session.invalidate();
    	return ResponseEntity.ok("logged out");
    }
}