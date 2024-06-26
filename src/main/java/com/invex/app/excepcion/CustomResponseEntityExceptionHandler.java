package com.invex.app.excepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.invex.app.model.ResponseDetails;

import javassist.tools.web.BadHttpRequest;


@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                    HttpHeaders headers, HttpStatus status, WebRequest request) {
            return new ResponseEntity<Object>(
                            ResponseDetails.builder().message(ex.getMessage()).code(status.value())
                                            .reason(status.getReasonPhrase())
                                            .path(StringUtils.split(request.getDescription(false), "=")[1]).build(),
                            status);
    }
    
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDetails> handleMyCustomException(DataIntegrityViolationException ex, WebRequest request) {
        return new ResponseEntity<ResponseDetails>(
                ResponseDetails.builder().message(ex.getMostSpecificCause().getMessage())
                                .code(HttpStatus.BAD_REQUEST.value())
                                .reason(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .path(StringUtils.split(request.getDescription(false), "=")[1]).build(),
                HttpStatus.BAD_REQUEST);
    }
	     

    
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ResponseDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
                    WebRequest request) {
            return new ResponseEntity<ResponseDetails>(
                            ResponseDetails.builder().message(ex.getMessage()).code(HttpStatus.NOT_FOUND.value())
                                            .reason(HttpStatus.NOT_FOUND.getReasonPhrase())
                                            .path(StringUtils.split(request.getDescription(false), "=")[1]).build(),
                            HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<ResponseDetails> handleUnauthorizedException(UnauthorizedException ex,
                    WebRequest request) {
            return new ResponseEntity<ResponseDetails>(
                            ResponseDetails.builder().message(ex.getMessage()).code(HttpStatus.UNAUTHORIZED.value())
                                            .reason(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                                            .path(StringUtils.split(request.getDescription(false), "=")[1]).build(),
                            HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(ErrorFieldsException.class)
    protected ResponseEntity<ResponseDetails> handleErrorFieldsException(ErrorFieldsException ex,
                    WebRequest request) {
            return new ResponseEntity<ResponseDetails>(ResponseDetails.builder().message(ex.getMessage())
                            .code(HttpStatus.BAD_REQUEST.value()).reason(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .path(StringUtils.split(request.getDescription(false), "=")[1]).errors(ex.getErrors())
                            .build(), HttpStatus.BAD_REQUEST);
    }

}
