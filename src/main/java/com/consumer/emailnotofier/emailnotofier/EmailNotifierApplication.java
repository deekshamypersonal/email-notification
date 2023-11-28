package com.consumer.emailnotofier.emailnotofier;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailNotifierApplication.class, args);
	}
	@Bean
	public MessageConverter converter(){
		return new Jackson2JsonMessageConverter();
	}
}
