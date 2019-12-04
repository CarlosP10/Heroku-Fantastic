package com.fantasticCode.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Habilita el manejo de transacciones
@EnableTransactionManagement
//Indica que es una clase de configuracion.
@Configuration
//Permite e indica el uso de repositorios en su paquete respectivo.
@EnableJpaRepositories(basePackages = "com.fantasticCode.repositories")
public class JpaConfiguration {
	// Metodo que se encarga de las transacciones con la base de datos de
	// postgresql.
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	// Bean que permite las persistenica y propiedades de JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("software");
		em.setPackagesToScan("com.fantasticCode.entities");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;
	}

	// Bean para hacer la conexion con la base de datos FantasticCode montada en
	// postgresql
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://ec2-174-129-255-106.compute-1.amazonaws.com:5432/df8f4b6pnd6eq0");
		dataSource.setUsername("wtpidvjiipzorf");
		dataSource.setPassword("2e19bb3691106bc5e3a1a761330d5c663ab4cf2b7b0951ba666434afee7bdb00");
		return dataSource;
	}

	// Propiedades de sql.
	Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;

	}
}