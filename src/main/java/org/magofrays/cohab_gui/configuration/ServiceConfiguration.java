package org.magofrays.cohab_gui.configuration;

import lombok.RequiredArgsConstructor;
import org.magofrays.cohab_gui.model.AuthModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {
	@Value("${web-client.base-url}")
	private String BASE_URL;
    private final WebClientFilter webClientFilter;

	@Bean
	public WebClient webClientWithTimeout() {
		return WebClient.builder()
				.baseUrl(BASE_URL)
				.filter(webClientFilter)
				.build();
	}

}
