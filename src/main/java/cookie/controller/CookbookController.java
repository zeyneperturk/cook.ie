package cookie.controller;

import cookie.model.Cookbook;
import cookie.repository.CookbookRepository;
import cookie.repository.UserRepository;
import cookie.service.CookbookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cookbooks")
public class CookbookController {
	
	@Autowired
	private CookbookService cookbookService;
	
	@GetMapping
	public List<Cookbook> getAllCookbooks() {
	   return cookbookService.getAllCookbooks();
	}

    @PostMapping
    public Cookbook createCookbook(Cookbook cookbook) {
    	return cookbookService.createCookbook(cookbook);
    }
}