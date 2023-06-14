package ua.shevchenko.multitenantapplication.multitenant.processors;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ua.shevchenko.multitenantapplication.multitenant.exceptions.EmptyTenantInRequestException;

@RequiredArgsConstructor
public class HeaderProcessor implements HttpRequestProcessor {
    private final String tenantHeader;

    @Override
    public String getTenantFromRequest(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getHeader(tenantHeader).isBlank()) {
            throw new EmptyTenantInRequestException("No parameter in the authentication field");
        }

        return httpServletRequest.getHeader(tenantHeader);
    }
}
