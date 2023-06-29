package ua.multitenanttestapp.configs;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.shevchenko.multitenantapplication.multitenant.processors.HeaderProcessor;
import ua.shevchenko.multitenantapplication.multitenant.processors.HttpRequestProcessor;
import ua.shevchenko.multitenantapplication.multitenant.processors.JwtProcessor;


@Configuration
@RequiredArgsConstructor
public class LibraryConfig {
    @Bean
    public HttpRequestProcessor getProcessor() {
        return new JwtProcessor("username");
    }

    /*@Bean
    public HttpRequestProcessor getProcessor() {
        return new HeaderProcessor("username");
    }*/
}
