package cookie.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cookie.model.Cookbook;
import cookie.model.Recipe;
import cookie.repository.CookbookRepository;

@Service
public class CookbookService {
	@Autowired
	private CookbookRepository cookbookRepository;
	
	public List<Cookbook> getAllCookbooks(){
		return cookbookRepository.findAll();
	}
	
	public Cookbook createCookbook(Cookbook cookbook)
	{
		cookbook.setCreation_date(new Date());
		System.out.println(cookbook.getTitle() + cookbook.getDescription() + cookbook.getCid());
		return cookbookRepository.save(cookbook);
	}

	public List<Cookbook> latestCookbooks() {
		return cookbookRepository.findTop5ByOrderByCreationDateDesc();
	}
}
