package com.poc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "first name must not be empty")
    @Size(min = 3, max = 15, message = "first name must be 3–15 chars")
    private String firstName;

    @NotBlank(message = "last name must not be empty")
    @Size(min = 3, max = 15, message = "last name must be 3–15 chars")
    private String lastName;

    @NotBlank(message = "email must not be empty")
    @Size(min = 10, max = 50, message = "email name must be 10–50 chars")
    private String email;

    @NotBlank(message = "password must not be empty")
    @Size(min = 10, max = 50, message = "password must be 10–50 chars")
    private String password;
}
