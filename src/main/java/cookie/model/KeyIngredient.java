package cookie.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class KeyIngredient implements Serializable{
	private int rid;
	private String name;
	
	public KeyIngredient(int rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}
	
	
	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public KeyIngredient() {
		super();
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, rid);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyIngredient other = (KeyIngredient) obj;
		return Objects.equals(name, other.name) && rid == other.rid;
	}
	
	
}
