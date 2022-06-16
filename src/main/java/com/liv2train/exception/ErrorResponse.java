package com.liv2train.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {

    private List<T> errors =new ArrayList<>(1);

    public ErrorResponse(List<T> errors){
        this.errors = errors;
    }

    public List<T> getErrors(){
        return errors;
    }
}
