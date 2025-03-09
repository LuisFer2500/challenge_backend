package com.api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan(basePackages = "com.api.rest")
@EntityScan("com.api.rest.entity")
@EnableJpaRepositories("com.api.rest.repository")
@EnableCaching
class ApiRestApplicationTests {

	@Test
	void contextLoads() {
	}

}
