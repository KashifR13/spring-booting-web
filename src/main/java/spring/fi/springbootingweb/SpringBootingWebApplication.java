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

	@Bean
	public CommandLineRunner fizzBuzzCLRChallenge (RestTemplate restTemplate)
			throws Exception {
		return args -> {

			LOG.info("Starting FIZZBUZZ CLR application...");

			for (int i=1; i<=100; i++) {

				if (i%3 == 0 && i%5 ==0)
					LOG.info("FizzBuzz");
				else if (i%3 == 0)
					LOG.info("Fizz");
				else if (i%5 == 0)
					LOG.info("Buzz");
				else
					LOG.info(i+" ");
			}

			LOG.info("Terminating FIZZBUZZ CLR application...");
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootingWebApplication.class, args);
	}

}
