package com.tanmay.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.addBasenames("classpath:message");
		source.setDefaultEncoding("UTF-8");
		
		return source;
	}
}
