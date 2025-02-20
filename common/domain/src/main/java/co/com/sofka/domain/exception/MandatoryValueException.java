package co.com.sofka.domain.exception;

public class MandatoryValueException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String REQUIRED_FIELD = "The field %s is required";

    public MandatoryValueException(String field) {
        super(String.format(REQUIRED_FIELD, field));
    }
}
