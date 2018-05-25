package com.lojavirtual.lojavirtual.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		Properties dbProps = new Properties();
		InputStream input = null;
		input = DataConfig.class.getClassLoader().getResourceAsStream("application.properties");
		if(input==null){
			System.out.println("Arquivo de configuração não encontrado.");
			return null;
		} 
		
		try {
			dbProps.load(input);
			dataSource.setDriverClassName(dbProps.getProperty("driver"));
			dataSource.setUrl(dbProps.getProperty("url"));
			dataSource.setUsername(dbProps.getProperty("username"));
			dataSource.setPassword(dbProps.getProperty("password"));
			return dataSource;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		
		return adapter;
	}
}
