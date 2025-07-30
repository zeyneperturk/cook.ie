package cookie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Instruction {
	
	@EmbeddedId
	private KeyInstruction id;
	
	private String text;
	
	@ManyToOne
	@MapsId("rid")
	@JoinColumn(name="rid")
	@JsonBackReference
	private Recipe recipe;

	public Instruction(int step_num, String text, Recipe recipe) {
		this.text = text;
		this.id = new KeyInstruction(step_num, recipe.getRid());
	}
	
	public Instruction() {
		this.id = new KeyInstruction();
	}

	public KeyInstruction getId() {
		return id;
	}

	public void setId(KeyInstruction id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
