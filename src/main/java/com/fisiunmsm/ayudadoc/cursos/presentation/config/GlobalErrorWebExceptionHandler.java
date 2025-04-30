package com.fisiunmsm.ayudadoc.cursos.presentation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fisiunmsm.ayudadoc.cursos.presentation.config.error.ApiErrorHandler;
import com.fisiunmsm.ayudadoc.cursos.presentation.config.error.ApiErrorResponse;

import reactor.core.publisher.Mono;
import java.util.Map;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

  private ApiErrorHandler apiErrorHandler;

  public GlobalErrorWebExceptionHandler(DefaultErrorAttributes defaultError,
                                        ApplicationContext applicationContext,
                                        ServerCodecConfigurer serverCodecConfigurer) {
    super(defaultError, new WebProperties.Resources(), applicationContext);
    super.setMessageWriters(serverCodecConfigurer.getWriters());
    super.setMessageReaders(serverCodecConfigurer.getReaders());
  }

  @Autowired
  public void setApiErrorHandler(ApiErrorHandler apiErrorHandler) {
    this.apiErrorHandler = apiErrorHandler;
  }

  @Override
  protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
    return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
  }

  private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
    final Map<String, Object> errorPropertiesMap = this.getErrorAttributes(request,
        ErrorAttributeOptions.defaults());

    ApiErrorResponse response = apiErrorHandler.handle(errorPropertiesMap, super.getError(request));

    return ServerResponse
        .status(response.getStatus())
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(response));
  }
}
