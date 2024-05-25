package com.network.aupair.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id", insertable=false, updatable=false, unique = true)
    private Long countryId;

    @Column(name = "iso", nullable = false, length = 2)
    private String iso;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "niceName", nullable = false, length = 80)
    private String niceName;

    @Column(name = "iso3", length = 3)
    private String iso3;

    @Column(name = "numCode")
    private Short numCode;

    @Column(name = "phoneCode", nullable = false)
    private Integer phoneCode;

    public Country(Long countryId) {
        this.countryId = countryId;
    }
}
