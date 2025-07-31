package cookie.mapper;

import cookie.dto.CategoryDTO;
import cookie.model.Category;

public class CategoryMapper {
	public static CategoryDTO toDTO (Category category) {
		if(category==null)return null;
		
		CategoryDTO dto = new CategoryDTO();
		dto.setName(category.getName());
		
		return dto;
	}
	
	public static Category toEntity(CategoryDTO dto) {
		if(dto==null) return null;
		
		Category category = new Category();
		category.setName(dto.getName());
		
		return category;
	}
}
