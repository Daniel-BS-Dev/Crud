package com.devsuperior.dscatalog.dto;

import javax.validation.constraints.Pattern;

public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$", message="Campo deve conter letra maiuscula, letra menuscula e numeros")
	private String password;
	
	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
