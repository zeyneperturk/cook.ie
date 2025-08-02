package cookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cookie.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	List<Recipe> findTop5ByOrderByCreationDateDesc();
	
	@Query (value = "SELECT * FROM recipe ORDER BY RAND() LIMIT 5", nativeQuery=true)
	public List<Recipe> recommendedRecipes();
}
