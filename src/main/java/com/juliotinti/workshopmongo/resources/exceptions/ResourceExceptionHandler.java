package com.juliotinti.workshopmongo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juliotinti.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice  //indica que essa classe que irá tratar possíveis erros nas requisições
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class) //isso serve para que quando ocorra um erro ObjectNotFoundException ele seja tratado aqui 
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
