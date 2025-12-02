//package org.magofrays.cohab_gui.configuration;
//
//import org.magofrays.cohab_gui.exception.AuthorizationException;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.web.reactive.function.client.ClientRequest;
//import org.springframework.web.reactive.function.client.ClientResponse;
//import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
//import org.springframework.web.reactive.function.client.ExchangeFunction;
//
//import reactor.core.publisher.Mono;
//
//
//public class WebClientFilter implements ExchangeFilterFunction{
//
//	@Override //Работает только в блокирующем режиме
// 	public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
//		return next.exchange(request).flatMap(response -> {
//			if(response.statusCode().isError()) {
//				handleError(response)
//			}
//			return Mono.just(response);
//		});
//	}
//	
//	public void handleError(ClientResponse response){
//		switch(response.statusCode().value()) {
//		case 401 -> throw new AuthorizationException();
//		//case 403 -> throw new AccessDeniedException();
//		//case 400 -> throw new BadRequestException();
//		}
//	}
//	
//
//}
