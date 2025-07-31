package cookie.mapper;

import cookie.dto.IngredientDTO;
import cookie.model.Ingredient;
import cookie.model.KeyIngredient;

public class IngredientMapper {
	public static IngredientDTO toDTO (Ingredient ingredient) {
		if(ingredient == null) return null;
		
		IngredientDTO dto = new IngredientDTO();
		dto.setName(ingredient.getId().getName());
		dto.setRid(ingredient.getId().getRid());
		dto.setQuantity(ingredient.getQuantity());
		dto.setUnit(ingredient.getUnit());
		
		return dto;
	}
	
	public static Ingredient toEntity (IngredientDTO dto) {
		if(dto == null) return null;
		
		Ingredient ingredient = new Ingredient();
		ingredient.setQuantity(dto.getQuantity());
		ingredient.setUnit(dto.getUnit());
		ingredient.setId(new KeyIngredient(dto.getRid(), dto.getName()));
		
		return ingredient;
	}

}
