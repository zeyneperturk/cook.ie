package cookie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookie.dto.CategoryDTO;
import cookie.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService = new CategoryService();
	
	@GetMapping("/popularCategories")
	public List<CategoryDTO> getCategories(){
		System.out.println("testController");
		return categoryService.popularCategories();
	}

}
