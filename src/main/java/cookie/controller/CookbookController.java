package cookie.controller;

import cookie.dto.CookbookDTO;
import cookie.mapper.CookbookMapper;
import cookie.model.Cookbook;
import cookie.model.Cookbook_Recipe;
import cookie.model.KeyCookbook_Recipe;
import cookie.model.Recipe;
import cookie.model.User;
import cookie.repository.CookbookRepository;
import cookie.repository.Cookbook_RecipeRepository;
import cookie.repository.UserRepository;
import cookie.service.CookbookService;
import cookie.service.RecipeService;
import cookie.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cookbooks")
public class CookbookController {
	
	@Autowired
	private CookbookService cookbookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private Cookbook_RecipeRepository crRepository;
	
	@GetMapping
	public List<CookbookDTO> getAllCookbooks() {
		List<Cookbook> cbs = cookbookService.getAllCookbooks();
	   return cbs.stream().map(CookbookMapper ::toDTO).collect(Collectors.toList());
	}

    @PostMapping
    public ResponseEntity<Object> createCookbook(@RequestBody CookbookDTO cookbook) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getPrincipal());
		
		if(auth == null || !auth.isAuthenticated())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
		String name = auth.getName();
		User user = userService.getUserByUsername(name);
		Cookbook save = CookbookMapper.toEntity(cookbook);
		save.setUser(user);
		cookbookService.createCookbook(save);
		
		if(cookbook.getRecipes() != null && !cookbook.getRecipes().isEmpty()) {
			
			for(Integer rid : cookbook.getRecipes()) {
				Recipe recipe = recipeService.findById(rid).orElseThrow(() -> new RuntimeException("Recipe not found"));

				Cookbook_Recipe cr = new Cookbook_Recipe(save, recipe);
				crRepository.save(cr);
			}
		}
		
		CookbookDTO dto = CookbookMapper.toDTO(save);
		return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/latest")
	public List<CookbookDTO> getLatestCookbooks(){
		List<Cookbook> latest = cookbookService.latestCookbooks();
		return latest.stream().map(CookbookMapper::toDTO).collect(Collectors.toList());
	}
    
    @GetMapping("/usersLatestCookbooks")
    public List<CookbookDTO> usersLatestCookbooks(int uid){
    	return cookbookService.usersLatestCookbooks(uid).stream().map(CookbookMapper::toDTO).collect(Collectors.toList());
    }
}