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

    @NotBlank(message = "{NotBlank.form.firstName}")
    @Size(min = 3, max = 15, message = "{Size.form.firstName}")
    private String firstName;

    @NotBlank(message = "{NotBlank.form.lastName}")
    @Size(min = 3, max = 15, message = "{Size.form.lastName}")
    private String lastName;

    @NotBlank(message = "{NotBlank.form.email}")
    @Size(min = 10, max = 50, message = "{Size.form.email}")
    private String email;

    @NotBlank(message = "{NotBlank.form.password}")
    @Size(min = 10, max = 50, message = "{Size.form.password}")
    private String password;
}
