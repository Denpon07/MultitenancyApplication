package ua.shevchenko.multitenantapplication;


import com.nimbusds.jwt.SignedJWT;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


class MultitenantApplicationTests {

	@Test
	void contextLoads() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIyIn0.rUQJtJ1o_BJAQ7AF-n__OEFalR7w4R7b8DrXsq06gco";

        SignedJWT jwt = null;
        try {
            jwt = SignedJWT.parse(token);
            String a = "";
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
	}

}
