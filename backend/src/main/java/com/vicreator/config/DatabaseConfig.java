```java
package com.vicreator.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("username")
                .password("password")
                .url("jdbc:mysql://localhost:3306/vicreator")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
```