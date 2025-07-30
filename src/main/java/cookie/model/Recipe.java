package cookie.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    
	private String title;
	
	@Column(name ="creation_date")
	private Date creationDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonBackReference
	private User user;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="cid", nullable = true)
	@JsonBackReference
	private Category category;
	
	@OneToMany(mappedBy = "recipe")
	@JsonManagedReference
    private List<Cookbook_Recipe> cookbookRecipes;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ingredient> ingredients;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Instruction> instructions;

    // Constructors
    public Recipe() {}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreation_date() {
		return creationDate;
	}

	public void setCreation_date(Date creation_date) {
		this.creationDate = creation_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Cookbook_Recipe> getCookbookRecipes() {
		return cookbookRecipes;
	}

	public void setCookbookRecipes(List<Cookbook_Recipe> cookbookRecipes) {
		this.cookbookRecipes = cookbookRecipes;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
	
	
   
}