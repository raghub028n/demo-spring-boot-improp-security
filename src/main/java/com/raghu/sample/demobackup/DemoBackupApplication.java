package com.raghu.sample.demobackup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.raghu.sample"})
@EnableJpaRepositories(basePackages = {"com.raghu.sample.repositories"})
@EntityScan(basePackages = {"com.raghu.sample.entities"})
public class DemoBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBackupApplication.class, args);
	}

}
