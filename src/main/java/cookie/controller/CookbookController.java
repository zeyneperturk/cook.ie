package cookie.controller;

import cookie.dto.CookbookDTO;
import cookie.mapper.CookbookMapper;
import cookie.model.Cookbook;
import cookie.model.Recipe;
import cookie.model.User;
import cookie.repository.CookbookRepository;
import cookie.repository.UserRepository;
import cookie.service.CookbookService;
import cookie.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cookbooks")
public class CookbookController {
	
	@Autowired
	private CookbookService cookbookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Cookbook> getAllCookbooks() {
	   return cookbookService.getAllCookbooks();
	}

    @PostMapping
    public ResponseEntity<Object> createCookbook(@RequestBody Cookbook cookbook) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getPrincipal());
		
		if(auth == null || !auth.isAuthenticated())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
		String name = auth.getName();
		User user = userService.getUserByUsername(name);
	
		cookbook.setUser(user);
		cookbookService.createCookbook(cookbook);
		CookbookDTO dto = CookbookMapper.toDTO(cookbook);
		return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/latest")
	public List<Cookbook> getLatestCookbooks(){
		return cookbookService.latestCookbooks();
	}
}