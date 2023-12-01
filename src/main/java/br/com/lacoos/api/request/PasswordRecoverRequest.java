package br.com.lacoos.api.request;

import lombok.Data;

@Data
public class PasswordRecoverRequest {

    private String password;
    private String confirmPassword;

}