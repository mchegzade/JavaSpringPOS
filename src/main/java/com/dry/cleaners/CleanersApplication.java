package com.dry.cleaners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class CleanersApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepo repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(CleanersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c = repo.findById(101);
		logger.info("{}", c.getId());
		logger.info("{}", c.toString());


		Customer newCustomer = Customer.builder()
				.name("Mosen")
				.number("65436799")
				.build();
		repo.save(newCustomer);
		Customer d = repo.findByName("mosen");
		logger.info("find by name 'mosen' => {}",d.toString());



	}

}
