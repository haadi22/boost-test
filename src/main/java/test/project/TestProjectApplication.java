package test.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = { "test.project","test.project.controller", "test.project.service"})
@EntityScan(basePackages = { "test.project.entity" })
@EnableJpaRepositories
@Log4j2
public class TestProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
		
		System.out.println("hello all!!!");
	}

}
