package cookie.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cookie.dto.CategoryDTO;
import cookie.mapper.CategoryMapper;
import cookie.model.Category;
import cookie.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category)
	{
		return categoryRepository.save(category);
	}

	public List<CategoryDTO> popularCategories(){
		System.out.println("test");
		List<Category> all = categoryRepository.findAll();
		System.out.println("test");
		Collections.shuffle(all);
		System.out.println("test");
		System.out.println(all);
		return all.stream().limit(5).map(CategoryMapper::toDTO).collect(Collectors.toList());
	}
}
