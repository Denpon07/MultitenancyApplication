package ua.shevchenko.multitenantapplication.datasource.exceptions;

public class TenantNotInConfigurationException extends RuntimeException {
    public TenantNotInConfigurationException(String message) {
        super(message);
    }
}