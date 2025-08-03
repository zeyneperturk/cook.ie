package cookie.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Recipe> latestRecipes(){
		return recipeRepository.findTop5ByOrderByCreationDateDesc();
	}
	
	public List<Recipe> recommendedRecipesForCookbok(){
		return recipeRepository.recommendedRecipes();
	}
	
	public Optional<Recipe> findById(int rid) {
		return recipeRepository.findById(rid);
	}
}
