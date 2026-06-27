package cookie.controller;

import cookie.dto.LoginRequest;
import cookie.dto.SignupRequest;
import cookie.dto.UserDTO;
import cookie.mapper.UserMapper;
import cookie.model.User;
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
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> getAllUsers() {
	   return userService.getAllUsers().stream()
			   .map(UserMapper::toDTO)
			   .collect(Collectors.toList());
	}
    
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody SignupRequest request)
    {
    	if(isBlank(request.getUsername()) || isBlank(request.getEmail()) || isBlank(request.getPassword())
    			|| isBlank(request.getFirst_name()) || isBlank(request.getLast_name()))
    		return ResponseEntity.badRequest().body(Map.of("error", "All fields are required"));

    	if(userService.existsByEmail(request.getEmail()))
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "Email already in use"));

    	if(userService.existsByUsername(request.getUsername()))
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "Username already taken"));

    	User user = new User();
    	user.setFirst_name(request.getFirst_name());
    	user.setLast_name(request.getLast_name());
    	user.setUsername(request.getUsername());
    	user.setEmail(request.getEmail());
    	user.setPassword(request.getPassword());

    	User u = userService.createUser(user);
    	return ResponseEntity.ok(UserMapper.toDTO(u));
    }

    private boolean isBlank(String s) {
    	return s == null || s.trim().isEmpty();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) throws AuthenticationException {
        
    	try {
    	UsernamePasswordAuthenticationToken authToken =
		    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

		Authentication authentication = auth.authenticate(authToken);

		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		HttpSession session = request.getSession(true);
		session.setAttribute(
		    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
		    context
		);
		String username = authentication.getName();
		User user = userService.getUserByUsername(username);
		UserDTO dto = UserMapper.toDTO(user);
	    session.setAttribute("user", dto);

		return ResponseEntity.ok(dto);
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
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