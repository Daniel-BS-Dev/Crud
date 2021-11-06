package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.RoleDTO;
import com.devsuperior.dscatalog.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
}
