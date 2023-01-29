package spring.fi.springbootingweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spring.fi.springbootingweb.models.Room;

import java.util.List;

@SpringBootApplication
public class SpringBootingWebApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootingWebApplication.class);

	@Bean
	public RestTemplate restTemplate (RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner (RestTemplate restTemplate)
			throws Exception {
		return args -> {
			LOG.info("Starting CommandLineRunner application...");

			ResponseEntity<List<Room>> rooms =
					restTemplate.exchange("http://localhost:6060/api/rooms", HttpMethod.GET,
							null, new ParameterizedTypeReference<List<Room>>() {
					});

			rooms.getBody().forEach(room -> {
				LOG.info(room.toString());
			});

			LOG.info("Terminating CommandLineRunner application...");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootingWebApplication.class, args);
	}

}
