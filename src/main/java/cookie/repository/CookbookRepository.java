package cookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Cookbook;
import cookie.model.Recipe;
import cookie.model.User;

public interface CookbookRepository extends JpaRepository<Cookbook, Integer>{

	List<Cookbook> findTop5ByOrderByCreationDateDesc();
	
	List<Cookbook> findTop5ByUserOrderByCreationDateDesc(User user);
	
}
