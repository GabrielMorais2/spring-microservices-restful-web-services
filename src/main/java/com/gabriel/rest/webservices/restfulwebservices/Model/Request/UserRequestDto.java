package com.gabriel.rest.webservices.restfulwebservices.Model.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {

    @NotBlank(message = "Name is required")
    String name;

    @NotNull(message = "Birth Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birth Date should be in the past")
    LocalDate birthDate;
}
