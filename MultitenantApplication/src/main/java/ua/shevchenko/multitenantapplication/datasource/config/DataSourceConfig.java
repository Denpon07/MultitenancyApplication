package ua.shevchenko.multitenantapplication.datasource.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.shevchenko.multitenantapplication.datasource.dinamicConectDataSource.TenantAwareRoutingDataSource;
import ua.shevchenko.multitenantapplication.datasource.models.DataSourceProperties;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final DataSourceProperties tenantProperties;

    @Bean
    public DataSource getDataSource() {
        TenantAwareRoutingDataSource tenantAwareRoutingDataSource = new TenantAwareRoutingDataSource(tenantProperties);
        tenantAwareRoutingDataSource.setTargetDataSources(tenantProperties.getDataSources());
        tenantAwareRoutingDataSource.afterPropertiesSet();

        return tenantAwareRoutingDataSource;
    }
}
