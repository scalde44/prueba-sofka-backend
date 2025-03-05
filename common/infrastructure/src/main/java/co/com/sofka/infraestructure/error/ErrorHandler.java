package co.com.sofka.infraestructure.error;

import co.com.sofka.domain.exception.DuplicateException;
import co.com.sofka.domain.exception.InvalidValueException;
import co.com.sofka.domain.exception.MandatoryValueException;
import co.com.sofka.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    private static final String DEFAULT_MESSAGE = "Ocurrio un error inesperado.";

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetail handleNotFoundException(NotFoundException ex) {
        return new ErrorDetail(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorDetail handleDuplicateException(DuplicateException ex) {
        return new ErrorDetail(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler({
            MandatoryValueException.class,
            InvalidValueException.class,
            IllegalArgumentException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDetail handleIllegalArgumentExceptions(RuntimeException ex) {
        return new ErrorDetail(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetail handleDefaultException(Exception ex) {
        return new ErrorDetail(ex.getClass().getSimpleName(), DEFAULT_MESSAGE);
    }
}
