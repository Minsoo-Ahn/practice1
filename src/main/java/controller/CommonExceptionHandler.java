package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("프로젝트명")
public class CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error/commonException";
	}
}
