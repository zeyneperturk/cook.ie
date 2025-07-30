package cookie.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cookbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    
    private String title;
    
    @Column(name="creation_date")
    private Date creationDate;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="uid", nullable = true)
    @JsonBackReference("cookbook-user")
    private User user;
    
    public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public List<Cookbook_Recipe> getCookbookRecipes() {
		return cookbookRecipes;
	}

	public void setCookbookRecipes(List<Cookbook_Recipe> cookbookRecipes) {
		this.cookbookRecipes = cookbookRecipes;
	}

	@OneToMany(mappedBy = "cookbook")
	@JsonManagedReference("cookbook-key-link")
    private List<Cookbook_Recipe> cookbookRecipes;
    
}