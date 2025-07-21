package cookie.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class KeyCookbook_Recipe implements Serializable{
	
	private int cid;
	private int rid;
	
	public KeyCookbook_Recipe() {
		super();
	}

	public KeyCookbook_Recipe(int cid, int rid) {
		super();
		this.cid = cid;
		this.rid = rid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cid, rid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyCookbook_Recipe other = (KeyCookbook_Recipe) obj;
		return cid == other.cid && rid == other.rid;
	}
	
	

}
