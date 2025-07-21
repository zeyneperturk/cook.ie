package cookie.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class KeyInstruction implements Serializable{
	
	private int step_num;
	private int rid;
	
	public KeyInstruction(int step_num, int rid) {
		super();
		this.step_num = step_num;
		this.rid = rid;
	}

	public KeyInstruction() {
		super();
	}

	public int getStep_num() {
		return step_num;
	}

	public void setStep_num(int step_num) {
		this.step_num = step_num;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rid, step_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyInstruction other = (KeyInstruction) obj;
		return rid == other.rid && step_num == other.step_num;
	}
	
	

}
