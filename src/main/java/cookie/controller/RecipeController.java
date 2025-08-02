package cookie.controller;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Date;
import org.springframework.core.*;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookie.dto.RecipeDTO;
import cookie.mapper.RecipeMapper;
import cookie.model.Ingredient;
import cookie.model.Instruction;
import cookie.model.KeyIngredient;
import cookie.model.KeyInstruction;
import cookie.model.Recipe;
import cookie.model.User;
import cookie.repository.IngredientRepository;
import cookie.repository.InstructionRepository;
import cookie.repository.RecipeRepository;
import cookie.repository.UserRepository;
import cookie.service.RecipeService;
import cookie.service.UserService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private IngredientRepository ingRepository;
	
	@Autowired
	private InstructionRepository insRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody Recipe recipe)
    {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth == null || !auth.isAuthenticated())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
		String name = auth.getName();
		User user = userService.getUserByUsername(name);
	
		recipe.setUser(user);
		recipe.setCreation_date(new Date());
		
		List<Ingredient> ing = recipe.getIngredients();
		List<Instruction> ins = recipe.getInstructions();
		
		recipe.setIngredients(null);
		recipe.setInstructions(null);
		
		Recipe save = recipeService.createRecipe(recipe);
		

		if(ing!=null)
		{
			for(Ingredient val : ing)
			{
				val.setRecipe(save);
				val.setId(new KeyIngredient(save.getRid(), val.getId().getName()));
				ingRepository.save(val);
			}
			
		}
		
		if(ins!=null)
		{
			for(Instruction val : ins)
			{
				val.setRecipe(save);
				val.setId(new KeyInstruction(val.getId().getStep_num(), save.getRid()));
				insRepository.save(val);
			}
		}
		
		Recipe finalSave = recipeService.createRecipe(save);
		RecipeDTO dto = RecipeMapper.toDTO(finalSave);
    	return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/allRecipes")
	public List<RecipeDTO> getRecipes() {
		return recipeService.getAllRecipes().stream()
				.map(RecipeMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/latest")
	public List<RecipeDTO> getLatestRecipes(){
		List<Recipe> latest = recipeService.latestRecipes();
		return latest.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
	}
	
	@GetMapping("/recommendedForCookbook")
	public List<RecipeDTO> recommendedRecipes(){
		List<Recipe> recommended = recipeService.recommendedRecipesForCookbok();
		return recommended.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
	}
}
