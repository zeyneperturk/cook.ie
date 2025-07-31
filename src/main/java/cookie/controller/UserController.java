package cookie.controller;

import cookie.dto.LoginRequest;
import cookie.dto.UserDTO;
import cookie.mapper.UserMapper;
import cookie.model.User;
import cookie.repository.UserRepository;
import cookie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class UserController {
	
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public List<UserDTO> getAllUsers() {
	   return userService.getAllUsers().stream()
			   .map(UserMapper::toDTO)
			   .collect(Collectors.toList());
	}
    
    @PostMapping
    public UserDTO createUser(@RequestBody User user)
    {
    	User u = userService.createUser(user);
    	return UserMapper.toDTO(u);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) throws AuthenticationException {
        
    	try {
    	UsernamePasswordAuthenticationToken authToken =
		    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

		Authentication authentication = auth.authenticate(authToken);

		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		request.getSession(true).setAttribute(
		    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
		    context
		);
		String email = authentication.getName();
		User user = userService.getUserByEmail(email);
		UserDTO dto = UserMapper.toDTO(user);
	    request.getSession(true).setAttribute("user", dto);

		return ResponseEntity.ok(dto);
    	}catch(Exception e){
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
    	}
    }
    
    @GetMapping("/session")
    public ResponseEntity<?> getCurrentUser(HttpSession session)
    {
    	UserDTO dto = (UserDTO) session.getAttribute("user");
    	if(dto==null)
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Not logged in"));

    	return ResponseEntity.ok(dto);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session)
    {
    	session.invalidate();
    	return ResponseEntity.ok("logged out");
    }
}