package com.poc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import nablarch.fw.web.HttpResponse;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class JsonConverter {

    public static HttpResponse jsonResponse(int statusCode, Object payload) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(payload);
            return new HttpResponse(statusCode)
                    .setContentType("application/json; charset=UTF-8")
                    .write(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
