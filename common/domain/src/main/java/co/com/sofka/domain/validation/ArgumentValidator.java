package co.com.sofka.domain.validation;

import co.com.sofka.domain.exception.InvalidValueException;
import co.com.sofka.domain.exception.MandatoryValueException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ArgumentValidator {
    private ArgumentValidator() {
    }

    public static void validateRequired(Object value, String message) {
        if (Objects.isNull(value)) {
            throw new MandatoryValueException(message);
        }
    }

    public static void validateLessThan(Integer initialNumber, Integer finalNumber, String message) {
        if (initialNumber > finalNumber) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMinValue(BigDecimal value, BigDecimal minValue, String message) {
        if (value.compareTo(minValue) < 0) {
            throw new InvalidValueException(message);
        }
    }

    public static <E extends Enum<E>> E validateEnum(String value, Class<E> enumClass, String message) {
        Optional<E> optionalEnum = Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> e.toString().equals(value))
                .findFirst();

        if (optionalEnum.isEmpty()) {
            throw new InvalidValueException(message);
        }
        return optionalEnum.get();
    }

    public static void validateBefore(LocalDateTime startDate, LocalDateTime endDate, String message) {
        if (startDate.toLocalDate().isAfter(endDate.toLocalDate())) {
            throw new InvalidValueException(message);
        }
    }

    public static LocalDate validateDate(String date, String pattern, String message) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new InvalidValueException(message);
        }
    }
}
//    public static <T> void validateNotEmpty(List<T> list, String message) {
//        if (list.isEmpty()) {
//            throw new MandatoryValueException(message);
//        }
//    }


//    public static void validateEqual(Double value, Double expectedValue, String message) {
//        if (!value.equals(expectedValue)) {
//            throw new InvalidValueException(message);
//        }
//    }

//    public static void validateMinLength(Object value, int minLength, String message) {
//        if (value.toString().length() < minLength) {
//            throw new InvalidLengthException(message);
//        }
//    }
//
//    public static void validateMaxLength(Object value, int maxLength, String message) {
//        if (value.toString().length() > maxLength) {
//            throw new InvalidLengthException(message);
//        }
//    }
//
//    public static void validateBefore(LocalDateTime startDate, LocalDateTime endDate, String message) {
//        if (startDate.toLocalDate().isAfter(endDate.toLocalDate())) {
//            throw new InvalidValueException(message);
//        }
//    }
//
//    public static void validateTimeRange(LocalDateTime date, int startHour, int endHour, String message) {
//        if (date.getHour() < startHour || date.getHour() >= endHour) {
//            throw new InvalidValueException(message);
//        }
//    }
//
//
//
//    public static void validateRegex(String input, String regex, String message) {
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        if (!matcher.matches()) {
//            throw new InvalidValueException(message);
//        }
//    }
//
//    public static <E extends Enum<E>> E validateEnum(String value, Class<E> enumClass, String message) {
//        if (value != null) {
//            Optional<E> optionalEnum = Arrays.stream(enumClass.getEnumConstants())
//                    .filter(e -> e.toString().equals(value))
//                    .findFirst();
//
//            if (optionalEnum.isPresent()) {
//                return optionalEnum.get();
//            } else {
//                throw new InvalidValueException(message);
//            }
//        }
//        return null;
//    }


