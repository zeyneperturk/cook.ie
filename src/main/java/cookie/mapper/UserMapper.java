package cookie.mapper;

import cookie.dto.UserDTO;
import cookie.model.User;

public class UserMapper {
	public static UserDTO toDTO(User user) {
		if(user==null) return null;
		
		UserDTO dto = new UserDTO();
		dto.setUid(user.getUid());
		dto.setUsername(user.getUsername());
		dto.setFirst_name(user.getFirst_name());
		dto.setLast_name(user.getLast_name());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
	
	public static User toEntity(UserDTO dto) {
		if(dto==null) return null;
		
		User user = new User();
		user.setUid(dto.getUid());
		user.setUsername(dto.getUsername());
		user.setFirst_name(dto.getFirst_name());
		user.setLast_name(dto.getLast_name());
		user.setEmail(dto.getEmail());
		
		return user;
	}
}
