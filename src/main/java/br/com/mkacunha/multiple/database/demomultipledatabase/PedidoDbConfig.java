package br.com.mkacunha.multiple.database.demomultipledatabase;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pedidoEntityManagerFactory",
        transactionManagerRef = "pedidoTransactionManager", basePackages = {"br.com.mkacunha.multiple.database.demomultipledatabase.pedido"})
public class PedidoDbConfig {

    @Bean(name = "pedidoDataSource")
    @ConfigurationProperties(prefix = "pedido.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pedidoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pedidoEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("pedidoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("br.com.mkacunha.multiple.database.demomultipledatabase.pedido")
                .persistenceUnit("pedido")
                .build();
    }

    @Bean(name = "pedidoTransactionManager")
    public PlatformTransactionManager pedidoTransactionManager(
            @Qualifier("pedidoEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}
