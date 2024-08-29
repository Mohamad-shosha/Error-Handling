package com.shosha.springboot.demo.errorhandling.error;

import com.shosha.springboot.demo.errorhandling.error.error.ResponseError;
import com.shosha.springboot.demo.errorhandling.error.exception.EmptyException;
import com.shosha.springboot.demo.errorhandling.error.exception.StudentExistException;
import com.shosha.springboot.demo.errorhandling.error.exception.StudentNotFoundException;
import com.shosha.springboot.demo.errorhandling.util.TimingUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ResponseError> runTimeExceptionHandler(StudentNotFoundException exception) {
        ResponseError responseError = new ResponseError(exception.getErrorCode(),
                exception.getErrorMassage(),
                exception.getErrorDescription(),
                exception.getCurrentTimestamp());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ResponseError> runTimeExceptionHandler(EmptyException exception) {
        ResponseError responseError = new ResponseError(exception.getCode(),
                exception.getMessage(),
                exception.getDescription(),
                exception.getCurrentTime());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> responseErrorResponseEntity(MethodArgumentNotValidException exception) {
        String errorMassage = exception.getBindingResult().getFieldError().getField();
        String errorDescription = exception.getBindingResult().getFieldError().getDefaultMessage();
        ResponseError responseError = new ResponseError(1658, errorMassage
                ,errorDescription, TimingUtilities.timestamp());

        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseError> responseErrorResponseEntity(HttpMessageNotReadableException exception) {
        String errorMassage = "Invalid request";
        String errorDescription = exception.getLocalizedMessage();
        ResponseError responseError = new ResponseError(2000, errorMassage
                ,errorDescription,TimingUtilities.timestamp());

        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentExistException.class)
    public ResponseEntity<ResponseError> responseErrorResponseEntity(StudentExistException exception) {
        ResponseError responseError = new ResponseError(exception.getErrorCode(), exception.getErrorMassage()
                ,exception.getErrorDescription(),TimingUtilities.timestamp());

        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}
