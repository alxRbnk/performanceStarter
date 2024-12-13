package com.rbnk.performance.configuration;

import com.rbnk.performance.aspect.PerformanceMonitorAspect;
import com.rbnk.performance.properties.PerformanceMonitorProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@ConditionalOnProperty(prefix = "performance-monitor", name = "enabled", havingValue = "true", matchIfMissing = true)
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }
}
