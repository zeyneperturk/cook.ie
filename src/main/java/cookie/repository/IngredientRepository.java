package cookie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Ingredient;
import cookie.model.KeyIngredient;

public interface IngredientRepository extends JpaRepository<Ingredient, KeyIngredient>{

}
