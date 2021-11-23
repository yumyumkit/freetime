package com.project.yumyum.payload;

import lombok.Getter;
import lombok.Setter;
import sun.misc.FDBigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**요청을 담기위한 DTO 클래스*/
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
