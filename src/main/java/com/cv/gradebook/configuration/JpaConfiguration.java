package com.cv.gradebook.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.cv.gradebook.repository")
public class JpaConfiguration {
}
