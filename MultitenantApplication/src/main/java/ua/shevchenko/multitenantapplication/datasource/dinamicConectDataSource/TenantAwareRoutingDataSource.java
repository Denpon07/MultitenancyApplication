package ua.shevchenko.multitenantapplication.datasource.dinamicConectDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import ua.shevchenko.multitenantapplication.multitenant.TenantThreadLocalStorage;

public class TenantAwareRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return TenantThreadLocalStorage.getTenant();
    }
}
