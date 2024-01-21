package com.backend.from.architect.system.one.shot.task;

import com.backend.from.architect.system.one.shot.task.domain.Event;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoOneshotTaskApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoOneshotTaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String eventSource = args.getSourceArgs()[0];
		log.info(eventSource);
		try {
			Event event = objectMapper.readValue(eventSource, Event.class);
			if (event.isFailure()) {
				throw new RuntimeException("Failed to run task." + event);
			}
		} catch (JsonMappingException e) {
			throw new RuntimeException("Failed to run task." + eventSource, e);
		}
		log.info("succeed!");
	}
}
