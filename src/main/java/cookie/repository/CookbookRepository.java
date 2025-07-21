package cookie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Cookbook;

public interface CookbookRepository extends JpaRepository<Cookbook, Integer>{
	
}
