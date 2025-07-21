package cookie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}
