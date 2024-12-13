package com.rbnk.performance.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class PerformanceMonitorEnvPostProcessor implements EnvironmentPostProcessor {
    private final YamlPropertySourceLoader propertySourceLoader;

    public PerformanceMonitorEnvPostProcessor() {
        propertySourceLoader = new YamlPropertySourceLoader();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ClassPathResource resource = new ClassPathResource("performance-monitor-default.yaml");
        PropertySource<?> propertySource = null;
        try {
            propertySource = propertySourceLoader.load("performance-monitor", resource).get(0);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load performance-monitor config", e);
        }
        environment.getPropertySources().addLast(propertySource);
    }
}
