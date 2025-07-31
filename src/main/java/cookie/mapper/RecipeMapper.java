package cookie.mapper;

import cookie.dto.RecipeDTO;
import cookie.model.Recipe;

public class RecipeMapper {
	public static RecipeDTO toDTO(Recipe recipe) {
		if(recipe==null) return null;
		
		RecipeDTO dto = new RecipeDTO();
		dto.setTitle(recipe.getTitle());
		dto.setDescription(recipe.getDescription());
		dto.setCreation_date(recipe.getCreation_date());
		dto.setRid(recipe.getRid());
		
		return dto;
	}
	
	public static Recipe toEntity(RecipeDTO dto) {
		if(dto==null) return null;
		
		Recipe recipe = new Recipe();
		recipe.setTitle(dto.getTitle());
		recipe.setDescription(dto.getDescription());
		recipe.setCreation_date(dto.getCreation_date());
		recipe.setRid(dto.getRid());
		
		return recipe;
	}
}
