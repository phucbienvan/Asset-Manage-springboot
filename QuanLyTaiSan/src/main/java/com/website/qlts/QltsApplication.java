package com.website.qlts;

import com.website.qlts.exception.FileStorageProperties;
import com.website.qlts.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class QltsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QltsApplication.class, args);
	}

}
