package com.example.DataMasking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class DataMaskingApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DataMaskingApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
						.exposedHeaders("Access-Control-Expose-Headers", "Authorization")
						.allowedHeaders("Origin",
								"Accept",
								"X-Requested-With",
								"Content-Type",
								"Access-Control-Request-Method",
								"Access-Control-Request-Headers",
								"Access-Control-Allow-Methods",
								"Access-Control-Allow-Origin")

						.maxAge(3600).allowedOriginPatterns("http://localhost:4200");
			}
		};
	}
}
