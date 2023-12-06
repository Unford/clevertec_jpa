package ru.clevertec.course.jpa.exception;

public class UpdateConflictException extends ServiceException {
    public UpdateConflictException(String message) {
        super(message);
    }

    public UpdateConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateConflictException(Throwable cause) {
        super(cause);
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return CustomErrorCode.CONFLICT;
    }
}
