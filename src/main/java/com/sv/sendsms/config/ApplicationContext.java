package com.sv.sendsms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by anton
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sv.sendsms.*"})
@PropertySource("classpath:sendsms.properties")
public class ApplicationContext {
}
