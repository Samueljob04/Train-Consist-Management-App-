package models;

/**
 * Custom exception thrown when a Bogie has invalid capacity (<= 0)
 */
public class InvalidBogieCapacityException extends RuntimeException {
    public InvalidBogieCapacityException(String message) {
        super(message);
    }
}
