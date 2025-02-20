package co.com.sofka.infraestructure.error;

import co.com.sofka.domain.exception.DuplicateException;
import co.com.sofka.domain.exception.InvalidValueException;
import co.com.sofka.domain.exception.MandatoryValueException;
import co.com.sofka.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private static final String DEFAULT_MESSAGE = "Ocurrio un error, contactar más tarde.";
    private static final ConcurrentHashMap<String, Integer> STATUS_CODES = new ConcurrentHashMap<>();

    public ErrorHandler() {
        STATUS_CODES.put(MandatoryValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODES.put(InvalidValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODES.put(IllegalArgumentException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODES.put(DuplicateException.class.getSimpleName(), HttpStatus.CONFLICT.value());
        STATUS_CODES.put(NotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetail> handleAllExceptions(Exception exception) {
        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = STATUS_CODES.get(exceptionName);

        if (Objects.isNull(code)) {
            return new ResponseEntity<>(new ErrorDetail(exceptionName, DEFAULT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new ErrorDetail(exceptionName, message), HttpStatus.valueOf(code));
    }
}
