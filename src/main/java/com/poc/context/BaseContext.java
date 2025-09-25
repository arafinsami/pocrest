package com.poc.context;

import lombok.Data;

import java.util.List;

@Data
public class BaseContext<T> {
    private Long id;
    private T requestDto;
    private T responseDto;
    private List<T> responseList;
    private ProcessorStatus status;
    private boolean validationPassed;
    private String traceId;
}
