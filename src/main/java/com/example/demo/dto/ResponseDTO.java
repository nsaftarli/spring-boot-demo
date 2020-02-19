package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -1155875202345763871L;

    private Boolean success;
    private String error;
    private Object returnedValue;

    private ResponseDTO(ResponseDTOBuilder builder) {
        this.success = builder.success;
        this.returnedValue = builder.returnedValue;
        this.error = builder.error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public Object getReturnedValue() {
        return returnedValue;
    }

    public static class ResponseDTOBuilder<T> {
        private final Boolean success;
        private T returnedValue;
        private String error;

        public ResponseDTOBuilder(Boolean success) {
            this.success = success;
        }

        public ResponseDTOBuilder returned(T returned_value) {
            this.returnedValue = returned_value;
            return this;
        }

        public ResponseDTOBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ResponseDTO build() {
            ResponseDTO responseDTO = new ResponseDTO(this);
            return responseDTO;
        }
    }
}

