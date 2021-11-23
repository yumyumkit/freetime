package com.project.yumyum.payload;

import lombok.Getter;
import lombok.Setter;
import sun.misc.FDBigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class SignUpRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
