package com.met.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.met.model.Employee;

@Configuration   //<beans
@EnableTransactionManagement	//<tx:annotation-driven transaction-manager="hibernateTransactionManager"/>
@ComponentScan(basePackages = "com.met.*")		//<context:component-scan base-package="com.met.*"></context:component-scan>
@EnableWebMvc								//<mvc:annotation-driven />
public class MVCConfig {

	/*
	 * <bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name="prefix"> <value>/WEB-INF/pages/</value> </property> <property
	 * name="suffix"> <value>.jsp</value> </property> </bean>
	 */
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	/*
	 * <bean id="oracleDataSource"
	 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="oracle.jdbc.OracleDriver" />
	 * <property name="url" value="jdbc:oracle:thin:@iitdac.met.edu/xe" /> <property
	 * name="username" value="milind" /> <property name="password" value="pawar" />
	 * </bean>
	 */
	
	@Bean
	//@Primary
	public DataSource oracleDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@iitdac.met.edu/xe");
		ds.setUsername("milind");
		ds.setPassword("pawar");
		
		return ds;
		
		
	}
	
	/*
	 * <bean id="mySQLDataSource"
	 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="oracle.jdbc.OracleDriver" />
	 * <property name="url" value="jdbc:oracle:thin:@iitdac.met.edu/xe" /> <property
	 * name="username" value="milind" /> <property name="password" value="pawar" />
	 * </bean>
	 */
	
	@Bean
	public DataSource mySQLDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@iitdac.met.edu/xe");
		ds.setUsername("milind");
		ds.setPassword("pawar");
		
		return ds;
		
		
	}
	
	/*
	 * <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
	 * <property name="dataSource" ref="oracleDataSource"></property> </bean>
	 */
	
	
	/*
	 * @Bean public JdbcTemplate jdbcTemplate() {
	 * 
	 * JdbcTemplate template = new JdbcTemplate();
	 * template.setDataSource(oracleDataSource());
	 * 
	 * return template; }
	 */
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("oracleDataSource") DataSource ds) {
		
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(ds);
		 
		return template;
	}
	
	/*
	 * <bean id="sessionFactoryBean"
	 * class="org.springframework.orm.hibernate4.LocalSessionFactoryBean"> <property
	 * name="dataSource" ref="oracleDataSource"></property> <property
	 * name="annotatedClasses"> <list> <value>com.met.model.Employee</value> </list>
	 * </property> <property name="hibernateProperties"> <props> <prop
	 * key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop> <prop
	 * key="hibernate.show_sql">true</prop> </props> </property> </bean>
	 */
	
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(oracleDataSource());
		sessionFactoryBean.setAnnotatedClasses(new Class[] {Employee.class});
		sessionFactoryBean.setHibernateProperties(properties());
		
		return sessionFactoryBean;
	}
	
	/*
	 * <props> <prop
	 * key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop> <prop
	 * key="hibernate.show_sql">true</prop> </props>
	 */
	
	
	@Bean
	public Properties properties() {
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.show_sql", "true");
		
		return properties;
	}
	
	
	/*
	 * <bean id="hibernateTransactionManager"
	 * class="org.springframework.orm.hibernate4.HibernateTransactionManager">
	 * <property name="sessionFactory" ref="sessionFactoryBean"></property> </bean>
	 */
	
	@Bean
	public HibernateTransactionManager htm(SessionFactory sf) {
		
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sf);
		
		return htm;
		
	}
	
}
