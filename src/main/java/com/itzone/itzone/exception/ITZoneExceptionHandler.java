package com.itzone.itzone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ITZoneExceptionHandler {
    /**
     * ITZone 서비스 내부 커스텀 예외처리
     *
     * @param e     커스텀 예외 Class
     * @return      ErrorResponse
     */
    @ExceptionHandler(ITZoneException.class)
    public ResponseEntity<ErrorResponse> handleITZoneException(ITZoneException e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus())
                .body(ErrorResponse.of(errorCode,e.getMessage()));
    }

    /**
     * @Valid 애너테이션 - @NotBlank, @NotNull, @NotEmpty, etc...
     * javax.validation.constraints에 해당하는 애너테이션의 조건에 부적합하면 MethodArgumentNotValidException 발생 예외 핸들링
     *
     * @param e     MethodArgumentNotValidException
     * @return      ErrorResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;

        List<String> errors = e.getBindingResult().getFieldErrors()
                        .stream()
                        .map(ex -> ex.getField() + " : " + ex.getDefaultMessage())
                        .toList();

        return ResponseEntity.status(errorCode.getStatus())
                .body(ErrorResponse.of(errorCode,errors.toString()));
    }
}
