package org.magofrays.cohab_gui.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceConfiguration {
	@Value("${web-client.base-url}")
	private static String BASE_URL;
	
	@Bean
	public WebClient webClientWithTimeout() {
		return WebClient.builder()
				.baseUrl(BASE_URL)
//				.filter(new WebClientFilter())
				.build();
	}
	
}
