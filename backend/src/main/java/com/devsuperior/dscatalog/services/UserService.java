package com.devsuperior.dscatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

}
