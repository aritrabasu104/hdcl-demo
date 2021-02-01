package com.hcl.usecase.api.error.handler;

import com.hcl.usecase.api.error.InsufficientBalanceException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 400:
                return new InsufficientBalanceException();
            default:
                return new Exception("Generic error");
        }
    }
}
