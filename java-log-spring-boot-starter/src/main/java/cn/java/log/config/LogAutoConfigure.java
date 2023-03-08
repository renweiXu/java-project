package cn.java.log.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 声明是配置类
 * @ComponentScan 配置扫描的路径
 * @ConditionalOnProperty 指定 配置文件中 log开头的配置 根据log.enable 来决定是否要加载当前类，
 * 如果配置文件中不存在该配置 或者配置为false则不加载，havingValue =true 表示 为true的时候加载
 * matchIfMissing=false 配置为false 表示 配置文件没配置 则不加载 ，=true 表示 配置文件没配置 默认加载
 */
@EnableConfigurationProperties
@Configuration
@ComponentScan({"cn.java.log.aspect","cn.java.log.config"})
@ConditionalOnProperty(prefix = "log",name = "enable",havingValue = "true",matchIfMissing = false)
public class LogAutoConfigure {
}
