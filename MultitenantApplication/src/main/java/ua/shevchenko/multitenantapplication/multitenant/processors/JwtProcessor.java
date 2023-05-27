package ua.shevchenko.multitenantapplication.multitenant.processors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class JwtProcessor implements HttpRequestProcessor {

    @Override
    public String getTenantFromRequest(HttpServletRequest httpServletRequest) {
        String token;
        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        } else {
            throw new RuntimeException("Invalid token"); //Пока что выбрасывает исключение
        }

        DecodedJWT jwt = JWT.decode(token);

        return jwt.getClaim("username").asString();
    }
}
