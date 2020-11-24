package com.mpf.beedeepayment.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MysqlDataSource {

    @Configuration
    public class DataSourceConfiguration {

        @Bean
        @ConfigurationProperties("spring.datasource")
        public HikariDataSource myDataSource() {
            return DataSourceBuilder.create().type(HikariDataSource.class).build();
        }
    }
}
