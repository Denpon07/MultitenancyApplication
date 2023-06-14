package ua.shevchenko.multitenantapplication.multitenant.exceptions;

public class EmptyTenantInRequestException extends RuntimeException {
    public EmptyTenantInRequestException(String message) {
        super(message);
    }
}
