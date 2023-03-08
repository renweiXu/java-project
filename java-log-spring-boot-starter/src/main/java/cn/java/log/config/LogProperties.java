package cn.java.log.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "log")
@Component
public class LogProperties {

    private boolean enable;

    @Value("${spring.application.name:#{null}}")
    private String appName;
}
