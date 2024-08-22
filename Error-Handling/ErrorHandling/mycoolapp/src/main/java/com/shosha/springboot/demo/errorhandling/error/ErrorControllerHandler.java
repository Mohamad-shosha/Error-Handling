package com.shosha.springboot.demo.errorhandling.error;

import com.shosha.springboot.demo.errorhandling.error.error.ResponseError;
import com.shosha.springboot.demo.errorhandling.error.exception.IsEmptyException;
import com.shosha.springboot.demo.errorhandling.error.exception.StudentNotFoundException;
import com.shosha.springboot.demo.errorhandling.util.TimingUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

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

    @ExceptionHandler(IsEmptyException.class)
    public ResponseEntity<ResponseError> runTimeExceptionHandler(IsEmptyException exception) {
        ResponseError responseError = new ResponseError(exception.getCode(),
                exception.getMessage(),
                exception.getDescription(),
                exception.getCurrentTime());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> responseErrorResponseEntity(MethodArgumentNotValidException exception) {
        String errorMassage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String errorDescription = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ResponseError responseError = new ResponseError(2000, exception.getMessage()
                , exception.getDetailMessageCode(), TimingUtilities.timestamp());

        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}
