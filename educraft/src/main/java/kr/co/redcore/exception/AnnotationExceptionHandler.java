package kr.co.redcore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AnnotationExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/exception");
		mv.addObject("exception", ex.getMessage());
		
		return mv;
    }
     
    @ExceptionHandler(RuntimeException.class) 
    public ModelAndView handleRuntimeException(RuntimeException ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/exception");
		mv.addObject("exception", ex.getMessage());
		
		return mv;
    }
}