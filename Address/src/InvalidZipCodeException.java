public class InvalidZipCodeException extends Exception {
    public InvalidZipCodeException() {
    }

    public InvalidZipCodeException(String message) {
        super(message);
    }

    public InvalidZipCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidZipCodeException(Throwable cause) {
        super(cause);
    }
}
