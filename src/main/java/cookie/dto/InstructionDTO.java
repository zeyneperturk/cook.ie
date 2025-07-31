package cookie.dto;

public class InstructionDTO {
	private int step_num;
	private String text;
	private int rid;
	
	public InstructionDTO() {
		super();
	}

	public int getStep_num() {
		return step_num;
	}

	public void setStep_num(int step_num) {
		this.step_num = step_num;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	
	
}
