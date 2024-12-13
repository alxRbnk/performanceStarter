package com.rbnk.performance.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "performance-monitor")
public class PerformanceMonitorProperties {

    private boolean enabled;
    private long minExecutionTime;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getMinExecutionTime() {
        return minExecutionTime;
    }

    public void setMinExecutionTime(long minExecutionTime) {
        this.minExecutionTime = minExecutionTime;
    }
}
