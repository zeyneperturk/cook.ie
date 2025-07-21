package cookie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookie.model.Recipe;
import cookie.repository.RecipeRepository;
import cookie.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe)
    {
    	return recipeService.createRecipe(recipe);
    }
	
	@GetMapping
	public List<Recipe> getRecipes() {
		return recipeService.getAllRecipes();
	}

}
