package com.invex.app.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class ConfigDatabase{
	
	
	/*
	@Primary
	@Bean(name = "InvexDatabase")
    public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://KDataBase-PC:6345/Invex?currentSchema=public");
        dataSourceBuilder.username("rIEwoRTE");
        dataSourceBuilder.password("JASS94SANDY1");
        return dataSourceBuilder.build();
    }
    */
	
	@Bean(name = "InvexDatabase")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ironbit?serverTimezone=UTC");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "" );
        return dataSource;
	}
}