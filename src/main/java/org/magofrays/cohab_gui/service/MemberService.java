package org.magofrays.cohab_gui.service;

import org.magofrays.cohab_gui.exception.NetworkException;
import org.magofrays.cohab_gui.exception.ValidationException;
import org.magofrays.cohab_gui.model.dto.LoginResponse;
import org.magofrays.cohab_gui.model.dto.Member;
import org.magofrays.cohab_gui.model.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final WebClient webClient;

    public LoginResponse createMember(Member member) {
        return webClient.post()
            .uri("/users")
            .bodyValue(member)
            .retrieve()
            .onStatus(
                    status -> status.equals(HttpStatus.BAD_REQUEST),
                    this::handleValidationError
                )
                .onStatus(
                    status -> status.equals(HttpStatus.REQUEST_TIMEOUT),
                    this::handleNetworkError
                )
            .bodyToMono(LoginResponse.class)
            .doOnSuccess(lr -> log.info("User created"))
            .block();
    }

//    private Mono<? extends Throwable> handleAuthorizationError(ClientResponse response){
//    	return response.bodyToMono(String.class)
//    }
    
    private Mono<? extends Throwable> handleNetworkError(ClientResponse response){
    	return Mono.error(new NetworkException());
    }
    
    private Mono<? extends Throwable> handleValidationError(ClientResponse response) {
        return response.bodyToMono(ValidationErrorResponse.class).flatMap(errorBody -> {
        	System.out.println("Client error: " + errorBody);
        	return Mono.error(new ValidationException(errorBody));
        });
    }

}