package cookie.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookie.model.Ingredient;
import cookie.model.Instruction;
import cookie.model.Recipe;
import cookie.repository.IngredientRepository;
import cookie.repository.InstructionRepository;
import cookie.repository.RecipeRepository;
import cookie.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private IngredientRepository ingRepository;
	
	@Autowired
	private InstructionRepository insRepository; 
	
	@PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe)
    {
		recipe.setCreation_date(new Date());
		
		List<Ingredient> ing = recipe.getIngredients();
		List<Instruction> ins = recipe.getInstructions();
		
		recipe.setIngredients(null);
		recipe.setInstructions(null);
		
		Recipe save = recipeService.createRecipe(recipe);
		
		if(ing!=null)
		{
			for(Ingredient val : ing)
				val.setRecipe(save);
		}
		
		if(ins!=null)
		{
			for(Instruction val : ins)
				val.setRecipe(recipe);
		}
		
		Recipe finalSave = recipeService.createRecipe(recipe);
		
    	return ResponseEntity.ok(finalSave);
    }
	
	@GetMapping
	public List<Recipe> getRecipes() {
		return recipeService.getAllRecipes();
	}

}
