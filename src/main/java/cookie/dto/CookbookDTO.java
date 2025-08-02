package cookie.dto;

import java.util.Date;
import java.util.List;

public class CookbookDTO {
	private String title;
	private String description;
	private Date creation_date;
	private List<Integer> recipes;
	
	public CookbookDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public List<Integer> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Integer> recipes) {
		this.recipes = recipes;
	}
	
	
}
