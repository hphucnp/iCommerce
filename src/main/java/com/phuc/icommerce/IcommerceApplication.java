package com.phuc.icommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableCaching
@EnableJpaRepositories(basePackages = { "com.phuc.icommerce.data.repository" })
@EntityScan(basePackages = { "com.phuc.icommerce.data.entity"})
@Slf4j
@SpringBootApplication
public class IcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcommerceApplication.class, args);
    }

}
