package org.magofrays.cohab_gui.service;

import org.magofrays.cohab_gui.exception.AuthorizationException;
import org.magofrays.cohab_gui.exception.NetworkException;
import org.magofrays.cohab_gui.exception.ValidationException;
import org.magofrays.cohab_gui.model.AuthModel;
import org.magofrays.cohab_gui.model.dto.auth.LoginRequest;
import org.magofrays.cohab_gui.model.dto.auth.LoginResponse;
import org.magofrays.cohab_gui.model.dto.ValidationErrorResponse;
import org.magofrays.cohab_gui.model.dto.auth.RegistrationRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final WebClient webClient;
    private final HttpErrorHandler httpErrorHandler;
    private final AuthModel authModel;

    public LoginResponse register(RegistrationRequest request) {
        return webClient.post()
            .uri("api/registration")
            .bodyValue(request)
            .retrieve()
            .onStatus(
                    status -> status.equals(HttpStatus.BAD_REQUEST),
                    httpErrorHandler::handleValidationError
                )
                .onStatus(
                    status -> status.equals(HttpStatus.REQUEST_TIMEOUT),
                    httpErrorHandler::handleNetworkError
                )
            .bodyToMono(LoginResponse.class)
            .doOnSuccess(lr -> log.info("User created"))
            .block();
    }

    public LoginResponse login(LoginRequest request){
        return webClient.post()
                .uri("api/login")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        status -> status.equals(HttpStatus.BAD_REQUEST),
                        httpErrorHandler::handleValidationError
                )
                .onStatus(
                        status -> status.equals(HttpStatus.REQUEST_TIMEOUT),
                        httpErrorHandler::handleNetworkError
                )
                .bodyToMono(LoginResponse.class).block();

    }

    public void isAuthenticated(){
        webClient.post()
                .uri("api/isAuthenticated")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + authModel.getAccessToken())
                .retrieve()
                .onStatus(
                        status -> status.equals(HttpStatus.UNAUTHORIZED),
                        httpErrorHandler::handleUnauthorizedError
                )
                .onStatus(status -> status.equals(HttpStatus.REQUEST_TIMEOUT),
                        httpErrorHandler::handleNetworkError)
                .bodyToMono(Boolean.class)
                .block();
    }
    


}