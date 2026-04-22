package busmanagement.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final Set<String> usedIds = new HashSet<>();

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isPositiveInt(int value) {
        return value > 0;
    }

    public static boolean isPositiveDouble(double value) {
        return value > 0;
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidId(String id) {
        return id != null && id.matches("^[A-Z]{2,5}\\d{2,5}$");
    }

    public static boolean isDuplicateId(String id) {
        if (usedIds.contains(id)) {
            return true;
        }
        usedIds.add(id);
        return false;
    }

    public static void validateString(String value, String fieldName) {
        if (isEmpty(value)) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }

    public static void validatePositiveInt(int value, String fieldName) {
        if (!isPositiveInt(value)) {
            throw new IllegalArgumentException(fieldName + " must be greater than zero.");
        }
    }

    public static void validatePositiveDouble(double value, String fieldName) {
        if (!isPositiveDouble(value)) {
            throw new IllegalArgumentException(fieldName + " must be greater than zero.");
        }
    }

    public static void validatePhone(String phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone number. It must contain exactly 10 digits.");
        }
    }

    public static void validateEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public static void validateId(String id, String fieldName) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid " + fieldName + ". Example format: PS101, BS202, TK303");
        }

        if (isDuplicateId(id)) {
            throw new IllegalArgumentException(fieldName + " already exists. Duplicate IDs are not allowed.");
        }
    }
}
