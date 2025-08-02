package cookie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cookie.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
