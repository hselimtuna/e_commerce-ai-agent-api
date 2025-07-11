package com.ecommerce.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatabaseConfig {

    @Bean(name = "devDatabaseURL")
    @Profile(value = "dev")
    public String devDatabaseUrl(){
        return "jdbc:postgresql://postgresql:5432/ecommerce_dev_db";
    }

    @Bean(name = "prodDatabaseURL")
    @Profile(value = "prod")
    public String prodDatabaseURL(){
        return "jdbc:postgresql://postgresql:5432/ecommerce_db";
    }
}
