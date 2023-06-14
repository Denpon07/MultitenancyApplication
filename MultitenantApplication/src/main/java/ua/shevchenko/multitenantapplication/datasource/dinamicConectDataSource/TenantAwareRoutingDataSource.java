package ua.shevchenko.multitenantapplication.datasource.dinamicConectDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import ua.shevchenko.multitenantapplication.datasource.exceptions.TenantNotInConfigurationException;
import ua.shevchenko.multitenantapplication.datasource.models.DataSourceProperties;
import ua.shevchenko.multitenantapplication.multitenant.TenantThreadLocalStorage;


public class TenantAwareRoutingDataSource extends AbstractRoutingDataSource {
    private final DataSourceProperties dataSourceProperties;

    public TenantAwareRoutingDataSource(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        for (Object key : dataSourceProperties.getDataSources().keySet()) {
            if (TenantThreadLocalStorage.getTenant().equals(key.toString())) {
                return TenantThreadLocalStorage.getTenant();
            }
        }

        throw new TenantNotInConfigurationException("The tenant named \"" + TenantThreadLocalStorage.getTenant()
                + "\" is not in the configuration");
    }

}
