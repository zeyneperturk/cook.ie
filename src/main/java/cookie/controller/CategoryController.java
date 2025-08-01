package cookie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookie.dto.CategoryDTO;
import cookie.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	CategoryService categoryService = new CategoryService();
	@GetMapping("/popularCategories")
	public List<CategoryDTO> getCategories(){
		return categoryService.popularCategories();
	}

}
