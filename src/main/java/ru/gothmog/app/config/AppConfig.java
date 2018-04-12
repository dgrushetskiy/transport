package ru.gothmog.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "ru.gothmog.app.*")
@PropertySource(value = {"classpath:database.properties"})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("ru.gothmog.app.model");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("connection.provider_class", environment.getRequiredProperty("connection.provider_class"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));

        properties.put("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));
        properties.put("hibernate.javax.cache.provider", environment.getRequiredProperty("hibernate.javax.cache.provider"));
        properties.put("hibernate.cache.use_second_level_cache", environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
        properties.put("hibernate.cache.use_query_cache", environment.getRequiredProperty("hibernate.cache.use_query_cache"));

        properties.put("hikari.dataSource.cachePrepStmts", environment.getRequiredProperty("hikari.dataSource.cachePrepStmts"));
        properties.put("hikari.dataSource.prepStmtCacheSize", environment.getRequiredProperty("hikari.dataSource.prepStmtCacheSize"));
        properties.put("hikari.dataSource.prepStmtCacheSqlLimit", environment.getRequiredProperty("hikari.dataSource.prepStmtCacheSqlLimit"));
        properties.put("hikari.dataSource.useServerPrepStmts", environment.getRequiredProperty("hikari.dataSource.useServerPrepStmts"));
        properties.put("hikari.idleTimeout", environment.getRequiredProperty("hikari.idleTimeout"));

        return properties;
    }

    @Bean
    public DataSource dataSource() {
        if (dataSource == null) {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(environment.getRequiredProperty("hibernate.hikari.dataSourceClassName"));
            hikariConfig.setJdbcUrl(environment.getRequiredProperty("hibernate.hikari.dataSource.url"));
            hikariConfig.setUsername(environment.getRequiredProperty("hibernate.hikari.username"));
            hikariConfig.setPassword(environment.getRequiredProperty("hibernate.hikari.password"));
            hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getRequiredProperty("hikari.maximumPoolSize")));
            dataSource = new HikariDataSource(hikariConfig);
        }
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
