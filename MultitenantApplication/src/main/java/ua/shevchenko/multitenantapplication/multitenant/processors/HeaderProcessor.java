package ua.shevchenko.multitenantapplication.multitenant.processors;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeaderProcessor implements HttpRequestProcessor {
    private final String tenantHeader;

    @Override
    public String getTenantFromRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(tenantHeader);
    }
}
