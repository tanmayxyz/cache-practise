package com.tanmay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String onNotFound(NotFoundException exc) {
		return exc.getMessage();
	}
}
