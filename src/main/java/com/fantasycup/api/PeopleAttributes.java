package com.fantasycup.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class PeopleAttributes {

    @JsonProperty
    @ApiModelProperty(
            name = "username",
            value = "Person Username",
            required = true
    )
    private String username;

    @JsonProperty
    @ApiModelProperty(
            name = "email",
            value = "person email",
            required = true
    )
    private String email;

    public PeopleAttributes(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public PeopleAttributes() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
