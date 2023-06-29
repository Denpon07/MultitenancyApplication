package ua.shevchenko.multitenantapplication.multitenant.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.shevchenko.multitenantapplication.multitenant.TenantThreadLocalStorage;
import ua.shevchenko.multitenantapplication.multitenant.processors.HttpRequestProcessor;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MultiTenancyFilter extends OncePerRequestFilter {

    private final HttpRequestProcessor httpRequestProcessor;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        TenantThreadLocalStorage.setTenant(
                httpRequestProcessor.getTenantFromRequest(request)
        );
        filterChain.doFilter(request, response);
    }

}