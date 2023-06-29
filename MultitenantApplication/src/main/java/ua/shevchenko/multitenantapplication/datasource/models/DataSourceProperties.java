package ua.shevchenko.multitenantapplication.datasource.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;


@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {
    private final Map<Object, Object> dataSources = new LinkedHashMap<>();

    public Map<Object, Object> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, Map<String, String>> dataSources) {
        dataSources.forEach(
                (key, value) -> this.dataSources.put(key, convert(value))
        );
    }

    private DataSource convert(Map<String, String> source) {
        DataSource dataSource = DataSourceBuilder.create()
                .url(source.get("jdbcUrl"))
                .driverClassName(source.get("driverClassName"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();

        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            String message = String.format("Failed to connect to database %s", source.get("jdbcUrl"));
            throw new RuntimeException(message);
        }

        return dataSource;
    }
}
