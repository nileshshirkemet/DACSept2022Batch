package com.met.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.met.model.JavaTrainer;
import com.met.model.Trainer;

@Configuration    // <beans 
@ComponentScan(basePackages = "com.met.model")	//<context:component-scan base-package="com.met.model"></context:component-scan>
@PropertySource("app.properties")
public class TrainingConfiguration {


	/*
	 * <bean id="javaTrainer" class="com.met.model.JavaTrainer"> <constructor-arg
	 * name="name" value="Ramesh"></constructor-arg> <constructor-arg
	 * name="subjects"> <list> <value>RMI</value> <value>Servlets</value>
	 * <value>JSP</value> <value>Web Services</value> </list> </constructor-arg>
	 * </bean>
	 */
	
	//javaTrainer -> funtion name is id= of the bean
	
	@Value("${jt1.name}")
	private String trainer1Name;
	
	
	@Value("#{${jt1.subjects}}")
	private List<String> trainer1Subjects;
	
	@Bean
	/*
	 * @Lazy
	 * 
	 * @Primary
	 * 
	 * @Scope(value = "singleton")
	 */
	public Trainer javaTrainer() {
		
		/*
		 * List<String> subjects = new ArrayList<>(4); subjects.add("RMI");
		 * subjects.add("Servlets"); subjects.add("JSP"); subjects.add("WebServices");
		 * 
		 * Trainer javaTrainer = new JavaTrainer("Ramesh", subjects);
		 */
		
		Trainer javaTrainer = new JavaTrainer(trainer1Name, trainer1Subjects);
		
		return javaTrainer;
		
	}
	
	/*
	 * <bean id="trainer" class="com.met.model.JavaTrainer"> <constructor-arg
	 * name="name" value="Ajay"></constructor-arg> <constructor-arg name="subjects">
	 * <list> <value>OOPS</value> <value>JDBC</value> <value>Collections</value>
	 * <value>Lambda</value> </list> </constructor-arg> </bean>
	 */
	
	
	@Value("${jt2.name}")
	private String trainer2Name;
	
	
	@Value("#{${jt2.subjects}}")
	private List<String> trainer2Subjects;
	
	@Bean("trainer")
	public Trainer javaTrainer1() {
		
		/*
		 * List<String> subjects = new ArrayList<>(4); subjects.add("OOPS");
		 * subjects.add("JDBC"); subjects.add("COLLECTIONS"); subjects.add("Generics");
		 * 
		 * Trainer javaTrainer = new JavaTrainer("Ajay", subjects);
		 */
		
		Trainer javaTrainer = new JavaTrainer(trainer2Name, trainer2Subjects);
		
		return javaTrainer;
		
	}
	
	
}
