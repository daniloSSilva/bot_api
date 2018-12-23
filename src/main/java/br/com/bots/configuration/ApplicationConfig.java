package br.com.bots.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public ModelMapper modelMapperFactoryBean() {
		return new ModelMapper();
	}

}
