package cookie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Cookbook_Recipe;
import cookie.model.KeyCookbook_Recipe;

public interface Cookbook_RecipeRepository extends JpaRepository<Cookbook_Recipe, KeyCookbook_Recipe>{
	

}
