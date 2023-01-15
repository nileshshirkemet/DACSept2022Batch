package com.met.iit.cdac.springbootweb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
//(exclude = DataSourceAutoConfiguration.class)

/*@Configuration
@ComponentScan(basePackages = "com.met.iit.cdac.springbootweb.*")
@EnableAutoConfiguration
*/
public class SpringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}

	/*
	 * @Bean public DataSource dataSource() {
	 * 
	 * DriverManagerDataSource ds = new DriverManagerDataSource();
	 * ds.setDriverClassName("oracle.jdbc.OracleDriver");
	 * ds.setUrl("jdbc:oracle:thin:@iitdac.met.edu/xe"); ds.setUsername("milind");
	 * ds.setPassword("pawar");
	 * 
	 * return ds;
	 * 
	 * 
	 * }
	 */
	
}
