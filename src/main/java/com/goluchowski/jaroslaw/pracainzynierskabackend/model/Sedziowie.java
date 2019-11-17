package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sedziowie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sedziowie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sedzia_id")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long sedzia_id;

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

}
