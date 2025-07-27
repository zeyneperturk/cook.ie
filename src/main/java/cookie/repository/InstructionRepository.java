package cookie.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cookie.model.Instruction;
import cookie.model.KeyIngredient;


public interface InstructionRepository extends JpaRepository<Instruction, KeyIngredient>{

}