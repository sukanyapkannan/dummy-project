package com.sinergia.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sinergia.model.Blog;
import com.sinergia.model.User;

@Configuration
@ComponentScan("com.sinergia")
@EnableTransactionManagement
public class DBConfig
{
	
		 @Autowired
		    @Bean
		    public SessionFactory sessionFactory(DataSource dataSource)
		 	{
		        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
		        sessionBuilder.setProperty("hibernate.show_sql", "true");
		        sessionBuilder.addProperties(getHibernateProperties());
		        sessionBuilder.addAnnotatedClass(User.class);
		        sessionBuilder.addAnnotatedClass(Blog.class);
		        
		         return sessionBuilder.buildSessionFactory();
		    }
		    @Autowired
		    @Bean(name = "datasource")
		    public DataSource dataSource() {
		        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		        dataSource.setDriverClassName("org.h2.Driver");
		        dataSource.setUrl("jdbc:h2:tcp://localhost/~/db2");

		        dataSource.setUsername("sa");
		        dataSource.setPassword("");
		        return dataSource;
		    }

		    private Properties getHibernateProperties() {
		        Properties properties = new Properties();
		        properties.put("hibernate.show_sql", "true");
		        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		        properties.put("hibernate.format_sql", "true");
		        properties.put("hibernate.hbm2ddl.auto", "update");
		        properties.put("hibernate.connection.autocommit", true);
		        return properties;
		    }
		    @Bean
			@Autowired
		        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
		                return new HibernateTransactionManager(sessionFactory);
		        }

}
