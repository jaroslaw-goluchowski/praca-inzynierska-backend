package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "siatkarze")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Siatkarze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siatkarz_id")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long siatkarz_id;

    @ApiModelProperty(example = "Artur")
    @Column(name = "imie", length = 20)
    @NotBlank(message = "Name is mandatory")
    private String imie;

    @ApiModelProperty(example = "Nowak")
    @Column(name = "nazwisko", length = 30)
    @NotBlank(message = "Name is mandatory")
    private String nazwisko;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data_urodzenia")
    @NotNull(message = "Date is mandatory")
    private Long data_urodzenia;

    @ApiModelProperty(example = "1.82")
    @Column(name = "wzrost", precision = 3, scale = 2)
    @NotNull(message = "Height is mandatory")
    private float wzrost;

    @ApiModelProperty(example = "Srodkowy")
    @Column(name = "pozycja")
    @NotBlank(message = "Position is mandatory")
    private String pozycja;

    @ManyToOne(targetEntity = Druzyny.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "druzyna_id")
    @JsonIgnore
    private Druzyny druzyna;

}
