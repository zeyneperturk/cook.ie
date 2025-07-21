package cookie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cookie.model.Recipe;
import cookie.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;
	
	public List<Recipe> getAllRecipes(){
		return recipeRepository.findAll();
	}
	
	public Recipe createRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
}
