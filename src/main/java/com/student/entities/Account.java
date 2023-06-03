package com.student.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "acccount")
public class Account {
    @Id
    private String id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String email;
    @JsonIgnore
    private String password;
    private List<String> roles = new ArrayList<>();

    public boolean isTrangThai() {
        return true;
    }


    public static class AccountBuilder {
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String email;
    @JsonIgnore
    private String password;



    public AccountBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public AccountBuilder setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public AccountBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account build() {
        Account user = new Account();
        user.setName(this.name);
        user.setGender(this.gender);
        user.setDateOfBirth(this.dateOfBirth);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
}
