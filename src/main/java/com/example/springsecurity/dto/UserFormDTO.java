package com.example.springsecurity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
public class UserFormDTO {
    @NonNull
    private String userEmail;
    @NonNull
    private String userPassword;
}
