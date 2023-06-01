package com.student.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto {
    private String id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    // email không được trùng nhau
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "password")
    private String password;
}
