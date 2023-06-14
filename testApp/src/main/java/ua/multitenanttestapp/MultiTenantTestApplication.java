package ua.multitenanttestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ua.shevchenko.multitenantapplication.DatasourseConfiguration;
import ua.shevchenko.multitenantapplication.multitenant.TenantThreadLocalStorage;

@SpringBootApplication
@Import({DatasourseConfiguration.class})
public class MultiTenantTestApplication {

	public static void main(String[] args) {
		TenantThreadLocalStorage.setTenant("user1");
		SpringApplication.run(MultiTenantTestApplication.class, args);

	}

}
