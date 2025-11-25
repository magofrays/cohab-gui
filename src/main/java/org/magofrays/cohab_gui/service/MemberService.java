//package org.magofrays.cohab_gui.service;
//
//import javax.swing.JOptionPane;
//import javax.swing.SwingUtilities;
//
//import org.magofrays.cohab_gui.model.Member;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.FieldError;
//import org.springframework.web.reactive.function.client.ClientResponse;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import lombok.RequiredArgsConstructor;
//import reactor.core.publisher.Mono;
//
//@Service
//@RequiredArgsConstructor
//public class MemberService {
//    private final WebClient webClient;
//
//    public Mono<Member> createUserWithValidationHandling(Member user) {
//        return webClient.post()
//            .uri("/users")
//            .bodyValue(user)
//            .retrieve()
//            .onStatus(HttpStatus.BAD_REQUEST::equals, this::handleValidationError)
//            .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, this::handleServerError)
//            .bodyToMono(Member.class)
//            .doOnSuccess(u -> System.out.println("User created: " + u.getId()))
//            .doOnError(ValidationException.class, error -> {
//                System.out.println("Validation failed: " + error.getMessage());
//                // Показываем пользователю конкретные ошибки
//                showValidationErrorsToUser(error);
//            });
//    }
//
//    private Mono<? extends Throwable> handleValidationError(ClientResponse response) {
//        return response.bodyToMono(ValidationErrorResponse.class)
//            .switchIfEmpty(Mono.defer(() -> {
//                // Если ответ не в ожидаемом формате, читаем как строку
//                return response.bodyToMono(String.class)
//                    .map(errorBody -> {
//                        ValidationErrorResponse errorResponse = new ValidationErrorResponse();
//                        errorResponse.setMessage(errorBody);
//                        return errorResponse;
//                    });
//            }))
//            .flatMap(errorResponse -> {
//                // Создаем кастомное исключение с деталями
//                ValidationException exception = new ValidationException(
//                    "Server validation failed",
//                    errorResponse
//                );
//                return Mono.error(exception);
//            });
//    }
//
//    private void showValidationErrorsToUser(ValidationException error) {
//        SwingUtilities.invokeLater(() -> {
//            if (error.getErrorResponse() != null &&
//                error.getErrorResponse().getErrors() != null) {
//
//                StringBuilder message = new StringBuilder("Validation errors:\n");
//                for (FieldError fieldError : error.getErrorResponse().getErrors()) {
//                    message.append("- ")
//                          .append(fieldError.getField())
//                          .append(": ")
//                          .append(fieldError.getMessage())
//                          .append("\n");
//                }
//
//                JOptionPane.showMessageDialog(null, message.toString(),
//                    "Validation Error", JOptionPane.ERROR_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, error.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        });
//    }
//}