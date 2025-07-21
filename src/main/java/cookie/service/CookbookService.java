package cookie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cookie.model.Cookbook;
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
		return cookbookRepository.save(cookbook);
	}
}
