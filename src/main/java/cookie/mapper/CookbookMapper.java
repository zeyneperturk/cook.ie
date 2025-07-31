package cookie.mapper;

import cookie.dto.CookbookDTO;
import cookie.model.Cookbook;

public class CookbookMapper {
	public static CookbookDTO toDTO (Cookbook cookbook) {
		if(cookbook==null) return null;
		
		CookbookDTO dto = new CookbookDTO();
		dto.setCreation_date(cookbook.getCreation_date());
		dto.setDescription(cookbook.getDescription());
		dto.setTitle(cookbook.getTitle());
		
		return dto;
	}
	
	public static Cookbook toEntity(CookbookDTO dto) {
		if(dto==null) return null;
		
		Cookbook cookbook = new Cookbook();
		cookbook.setCreation_date(dto.getCreation_date());
		cookbook.setDescription(dto.getDescription());
		cookbook.setTitle(dto.getTitle());
		
		return cookbook;
	}
}
