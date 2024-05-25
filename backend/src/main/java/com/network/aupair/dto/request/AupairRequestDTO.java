package com.network.aupair.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AupairRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Past
    private LocalDate dateOfBirth;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String picture;

    @NotNull
    @Min(value = 1)
    private Long countryOfOrigin;

    @NotBlank
    private String stateOfOrigin;

    @NotBlank
    private String cityOfOrigin;

    @NotNull
    @Min(value = 1)
    private Long aupairCountry;

    @NotBlank
    private String aupairCity;

}
