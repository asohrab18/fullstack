package com.foods.meerut.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RecipeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecipeException.class)
	public final ResponseEntity<ExceptionResponse> handleRecipeException(RecipeException ex, WebRequest wr)
			throws Exception {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
