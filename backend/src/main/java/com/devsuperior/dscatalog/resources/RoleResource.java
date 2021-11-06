package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.RoleDTO;
import com.devsuperior.dscatalog.services.RoleService;

@RestController
@RequestMapping(value="/roles")
public class RoleResource {
	
	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<Page<RoleDTO>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linePerPage", defaultValue="12") Integer linePerPage,
			@RequestParam(value="direction", defaultValue="DESC") String direction,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		
		Page<RoleDTO> list = service.findAllPage(pageRequest);
		
		return ResponseEntity.ok().body(list);
		
	}


}
