package org.magofrays.cohab_gui.service;

import lombok.extern.slf4j.Slf4j;
import org.magofrays.cohab_gui.exception.AuthorizationException;
import org.magofrays.cohab_gui.exception.NetworkException;
import org.magofrays.cohab_gui.exception.ValidationException;
import org.magofrays.cohab_gui.model.dto.ValidationErrorResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;


@Slf4j
@Component
public class HttpErrorHandler {
    public Mono<? extends Throwable> handleNetworkError(ClientResponse response){
        log.warn("Network connection error");
        return Mono.error(new NetworkException());
    }

    public Mono<? extends Throwable> handleUnauthorizedError(ClientResponse response){
        log.warn("Client is unauthorized");
        return Mono.error(new AuthorizationException("Войдите в аккаунт, либо зарегистрируйтесь!"));
    }

    public Mono<? extends Throwable> handleValidationError(ClientResponse response) {
        return response.bodyToMono(ValidationErrorResponse.class).flatMap(errorBody -> {
            log.warn("Client error: {}", errorBody);
            return Mono.error(new ValidationException(errorBody));
        });
    }
}
