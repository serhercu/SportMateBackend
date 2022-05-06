package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInitializer {

	@Autowired JdbcTemplate jdbcTemplate;
	
	
	@Bean
	CommandLineRunner initDatabase() {
		return new CommandLineRunner() {
			
		
		@Override
		public void run(String... args) throws Exception {
			}
		};
	}
}
