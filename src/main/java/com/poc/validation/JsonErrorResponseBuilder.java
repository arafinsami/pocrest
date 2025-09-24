package com.poc.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.Message;
import nablarch.core.validation.ValidationResultMessage;
import nablarch.fw.ExecutionContext;
import nablarch.fw.jaxrs.ErrorResponseBuilder;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonErrorResponseBuilder extends ErrorResponseBuilder {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public HttpResponse build(HttpRequest request,
                              ExecutionContext context,
                              Throwable throwable) {
        if (throwable instanceof ApplicationException appEx) {
            List<Message> messages = appEx.getMessages();
            Map<String, List<String>> errors = messages.stream()
                    .collect(Collectors.groupingBy(
                            msg -> (msg instanceof ValidationResultMessage vrm)
                                    ? vrm.getPropertyName()
                                    : msg.getMessageId(),
                            Collectors.mapping(Message::formatMessage, Collectors.toList())
                    ));
            try {
                String json = objectMapper.writeValueAsString(Map.of("errors", errors));
                return new HttpResponse(400)
                        .setContentType("application/json; charset=UTF-8")
                        .write(json);
            } catch (Exception e) {
                return new HttpResponse(500)
                        .setContentType("text/plain; charset=UTF-8")
                        .write("Failed to serialize validation errors");
            }
        }
        return super.build(request, context, throwable);
    }
}
