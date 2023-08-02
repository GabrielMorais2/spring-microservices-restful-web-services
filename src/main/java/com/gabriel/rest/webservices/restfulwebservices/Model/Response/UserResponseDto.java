package com.gabriel.rest.webservices.restfulwebservices.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    Long id;
    String name;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    LocalDate birthDate;
}
