package com.pheonix.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pheonix.domain"})
@EnableJpaRepositories(basePackages = {"com.pheonix.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
