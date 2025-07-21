package cookie.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Cookbook_Recipe {
	
	@EmbeddedId
	private KeyCookbook_Recipe id;
	
	@ManyToOne
	@MapsId("cid")
	@JoinColumn(name="cid")
	private Cookbook cookbook;
	
	@ManyToOne
	@MapsId("rid")
	@JoinColumn(name="rid")
	private Recipe recipe;

	public Cookbook_Recipe(Cookbook cookbook, Recipe recipe) {
		this.cookbook = cookbook;
		this.recipe = recipe;
		this.id = new KeyCookbook_Recipe(cookbook.getCid(), recipe.getRid());
	}
}
