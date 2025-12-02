package org.magofrays.cohab_gui.configuration;

import lombok.RequiredArgsConstructor;
import org.magofrays.cohab_gui.model.AuthModel;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WebClientFilter implements ExchangeFilterFunction {
    private final AuthModel authModel;

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        ClientRequest filteredRequest = ClientRequest.from(request)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + authModel.getAccessToken().getToken())
                .build();

        return next.exchange(filteredRequest);
    }
}
