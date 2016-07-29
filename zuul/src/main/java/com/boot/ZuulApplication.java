package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	
	 @Bean
	 public CorsFilter corsFilter() {
	     final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
	     final CorsConfiguration corsConfig = new CorsConfiguration();
	     corsConfig.setAllowCredentials(true);
	     corsConfig.addAllowedOrigin("*");
	     corsConfig.addAllowedHeader("*");
	     corsConfig.addAllowedMethod("OPTIONS");
	     corsConfig.addAllowedMethod("HEAD");
	     corsConfig.addAllowedMethod("GET");
	     corsConfig.addAllowedMethod("PUT");
	     corsConfig.addAllowedMethod("POST");
	     corsConfig.addAllowedMethod("DELETE");
	     corsConfig.addAllowedMethod("PATCH");
	     urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
	     return new CorsFilter(urlBasedCorsConfigurationSource);
	 }
}
