package com.fooddeliveryservice.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:persistence.xml" })
public class HibernateConfig {
}


