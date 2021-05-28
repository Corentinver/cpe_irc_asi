package com.cpe.configuration.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:global.properties")
public class GlobalProperties {
}
