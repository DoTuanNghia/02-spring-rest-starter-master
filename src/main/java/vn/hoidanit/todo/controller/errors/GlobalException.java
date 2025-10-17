package vn.hoidanit.todo.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.hoidanit.todo.entity.ApiResponse;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(NoSuchElementException ex) {
        var result = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "handleNotFound",null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAllException(Exception ex) {
        var result = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "handleAllException",null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }
}
