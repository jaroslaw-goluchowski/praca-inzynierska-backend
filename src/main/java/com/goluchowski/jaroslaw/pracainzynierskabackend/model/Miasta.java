package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "miasta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Miasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miasto_id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Koszalin")
    @Column(name = "nazwa", length = 40)
    @NotBlank(message = "Name is mandatory")
    private String nazwa;
}
