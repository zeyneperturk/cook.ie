package cookie.mapper;

import cookie.dto.InstructionDTO;
import cookie.model.Instruction;
import cookie.model.KeyInstruction;

public class InstructionMapper {
	public static InstructionDTO toDTO(Instruction instruction) {
		if(instruction == null) return null;
		
		InstructionDTO dto = new InstructionDTO();
		dto.setStep_num(instruction.getId().getStep_num());
		dto.setRid(instruction.getId().getRid());
		dto.setText(instruction.getText());
		
		return dto;
	}
	
	public static Instruction toEntity(InstructionDTO dto) {
		if(dto == null) return null;
		
		Instruction instruction = new Instruction();
		instruction.setText(dto.getText());
		instruction.setId(new KeyInstruction(dto.getStep_num(), dto.getRid()));
		
		return instruction;
	}
}
