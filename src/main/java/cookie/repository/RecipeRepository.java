package cookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	List<Recipe> findTop5ByOrderByCreationDateDesc();
}
