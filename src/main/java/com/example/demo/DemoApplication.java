package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        /*System.setProperty("file.encoding", "UTF-8");
        System.setProperty("sun.net.spi.nameservice.nameservers", "8.8.8.8,8.8.4.4");
        System.setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");*/
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Iterator<PropertySource<?>> iterator = propertySources.stream().iterator();
        while (iterator.hasNext()) {
            PropertySource<?> next = iterator.next();
            if (next instanceof EnumerablePropertySource) {
                EnumerablePropertySource enumerablePropertySource = (EnumerablePropertySource) next;
                String[] propertyNames = enumerablePropertySource.getPropertyNames();
                for (String propertyName : propertyNames) {
                    System.out.println(String.format("propertyName=【%s】,propertyValue=【%s】", propertyName, environment.getProperty(propertyName)));
                }
            }
        }
    }

}
