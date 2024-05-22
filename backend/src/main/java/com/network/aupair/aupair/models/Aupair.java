package com.network.aupair.aupair.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "aupair")
public class Aupair {

    @Id
    @UuidGenerator
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(unique = true, insertable = false, updatable = false)
    private String aupairId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false, length = 60, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "picture", length = 255)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "country_of_origin_id", referencedColumnName = "country_id")
    private Country countryOfOriginId;

    @Column(name = "state_of_origin", length = 255)
    private String stateOfOrigin;

    @Column(name = "city_of_origin", length = 255)
    private String cityOfOrigin;

    @ManyToOne
    @JoinColumn(name = "aupair_country_id", referencedColumnName = "country_id")
    private Country aupairCountryId;

    @Column(name = "aupair_city", length = 255)
    private String aupairCity;
}
