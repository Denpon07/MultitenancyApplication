package ua.shevchenko.multitenantapplication.multitenant.processors;

import jakarta.servlet.http.HttpServletRequest;

public interface HttpRequestProcessor {
    String getTenantFromRequest(HttpServletRequest httpServletRequest);
}
