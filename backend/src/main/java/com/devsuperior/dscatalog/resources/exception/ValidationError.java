package com.devsuperior.dscatalog.resources.exception;

import java.util.ArrayList;
import java.util.List;

// class que recebera o minha classe standarErro como herança e a class FieldMessage como linha
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String fieldMessage) {
		errors.add(new FieldMessage(fieldName, fieldMessage));
	}
}
