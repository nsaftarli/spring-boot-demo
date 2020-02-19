package com.example.demo.util;

import com.example.demo.dto.ResponseDTO;


public class ResponseGenerator {

    public static ResponseDTO generateResponseDTO(Object contents) {
        ResponseDTO responseDTO =
                new ResponseDTO.ResponseDTOBuilder<Object>(true)
                    .returned(contents)
                    .error(null)
                    .build();
        return responseDTO;
    }

    public static ResponseDTO generateExceptionDTO(Exception ex) {
        ResponseDTO responseDTO =
                new ResponseDTO.ResponseDTOBuilder<Object>(false)
                    .returned(null)
                    .error(ex.getMessage())
                    .build();
        return responseDTO;
    }
}
