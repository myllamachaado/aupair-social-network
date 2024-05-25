package com.network.aupair.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AupairResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String picture;
    private CountryResponseDTO countryOfOrigin;
    private String stateOfOrigin;
    private String cityOfOrigin;
    private CountryResponseDTO aupairCountry;
    private String aupairCity;
}
