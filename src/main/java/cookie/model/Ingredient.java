package cookie.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Ingredient {
	
	@EmbeddedId
	private KeyIngredient id;
	private float quantity;
	private String unit;
	
	@ManyToOne
	@MapsId("rid")
	@JoinColumn(name="rid")
	private Recipe recipe;

	public Ingredient(String name, float quantity, String unit, Recipe recipe) {
		this.quantity = quantity;
		this.unit = unit;
		this.id = new KeyIngredient(recipe.getRid(), name);
	}

	public KeyIngredient getId() {
		return id;
	}

	public void setId(KeyIngredient id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	
}
