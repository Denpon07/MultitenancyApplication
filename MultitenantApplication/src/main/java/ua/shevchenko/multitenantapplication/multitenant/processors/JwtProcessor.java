package ua.shevchenko.multitenantapplication.multitenant.processors;


import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ua.shevchenko.multitenantapplication.multitenant.exceptions.EmptyTenantInRequestException;

import java.net.http.HttpRequest;
import java.text.ParseException;

@RequiredArgsConstructor
public class JwtProcessor implements HttpRequestProcessor {
    private final String claimName;
    @Override
    public String getTenantFromRequest(HttpServletRequest httpServletRequest) {
        String token;
        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader.isEmpty() && authHeader.isBlank()){
            throw new EmptyTenantInRequestException("There is no header by name or it is empty.");
        } else if (authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }else {
            throw new EmptyTenantInRequestException("Formatting error in the field where the JWT token should be contained");
        }

        try {
            SignedJWT jwt = SignedJWT.parse(token);
            return (String) jwt.getJWTClaimsSet().getClaim(claimName);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
