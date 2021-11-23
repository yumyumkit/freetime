package com.project.yumyum.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/*
* 다음 request, response 페이로드는 컨트롤러 API에서 사용됨
* */
@Getter
public class LoginRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
