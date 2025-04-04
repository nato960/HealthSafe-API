package HealthSafe;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Deafault Server URL")})
@SpringBootApplication
public class HealthSafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSafeApplication.class, args);
	}

}
