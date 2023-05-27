package ua.shevchenko.multitenantapplication.cleaner.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ua.shevchenko.multitenantapplication.multitenant.TenantThreadLocalStorage;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TenantThreadLocalStorage.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}