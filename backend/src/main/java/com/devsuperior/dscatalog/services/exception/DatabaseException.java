package com.devsuperior.dscatalog.services.exception;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	// exceção quando eu vou pagar o meu produto associado a uma categoria
	public DatabaseException(String msg) {
		super(msg);
	}

}
