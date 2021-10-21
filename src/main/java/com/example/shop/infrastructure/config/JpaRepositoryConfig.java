package com.example.shop.infrastructure.config;


import com.example.shop.common.base.BaseJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class,
    basePackages = "com.example.shop.infrastructure.persistence.repository")
@Configuration
public class JpaRepositoryConfig {
}
