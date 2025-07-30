package cookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Cookbook;
import cookie.model.Recipe;

public interface CookbookRepository extends JpaRepository<Cookbook, Integer>{

	List<Cookbook> findTop5ByOrderByCreationDateDesc();
	
}
