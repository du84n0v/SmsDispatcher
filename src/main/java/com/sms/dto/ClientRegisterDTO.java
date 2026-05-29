package com.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterDTO {
    @NotBlank(message = "Company name should not be empty")
    private String companyName;
    @NotBlank(message = "Owner name should not be empty")
    private String ownerName;
    @NotBlank(message = "Owner surname should not be empty")
    private String ownerSurname;
    @Size(min = 13, max = 13, message = "Phone is wrong format")
    private String phone;
    @NotBlank(message = "Company name should not be empty")
    private String login;
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "Password should not be empty")
    @Size(min = 5, max = 16, message = "Password should be 5 length minimum and 16 length maximum")
    private String password;
}
