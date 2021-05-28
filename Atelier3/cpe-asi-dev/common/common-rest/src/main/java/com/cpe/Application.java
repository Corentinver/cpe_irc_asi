package com.cpe;

import com.cpe.configuration.common.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(
        basePackages = "com.cpe",
        excludeFilters = {
                @Filter(type = FilterType.REGEX, pattern = "com.cpe.configuration.*")
        })
@Import({
        GlobalProperties.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
