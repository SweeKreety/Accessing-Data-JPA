package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingdatajpaApplication {

	private static final Logger logger= LoggerFactory.getLogger(AccessingdatajpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) -> {
			//saving customers
			repository.save(new Customer("Rabin", "Hamal"));
			repository.save(new Customer("Sarina", "Tamang"));
			repository.save(new Customer("Sanju", "Khatri"));
			repository.save(new Customer("Tina", "Giri"));
			repository.save(new Customer("Milan", "Shrestha"));

			//fetching customers
			logger.info("Customers found with findAll():");
			logger.info("-------------------------------");
			for (Customer customer : repository.findAll()){
				logger.info(customer.toString());
			}
			logger.info("");

			//fetching individual customer by ID
			Customer customer= repository.findById(1L);
			logger.info("Customer found with findById(1L):");
			logger.info("----------------------------------");
			logger.info(customer.toString());
			logger.info("");

			//fetching customer by lastName
			logger.info("Customer found with findByLastName('Tamang'):");
			logger.info("---------------------------------------------");
			for (Customer tamang : repository.findByLastName("Tamang")) {
				logger.info(tamang.toString());
			}
			logger.info("");
		};
		}
	}

