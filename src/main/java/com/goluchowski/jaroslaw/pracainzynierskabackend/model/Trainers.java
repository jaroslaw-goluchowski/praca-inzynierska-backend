package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "trainers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(example = "Artur")
    @Column(name = "first_name", length = 20)
    @NotBlank
    private String firstName;

    @ApiModelProperty(example = "Nowak")
    @Column(name = "last_name", length = 30)
    @NotBlank
    private String lastName;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "date_of_birth")
    @NotBlank
    private Date dateOfBirth;
}
