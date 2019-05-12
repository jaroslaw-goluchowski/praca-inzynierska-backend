package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trainers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Artur")
    @Column(name = "first_name", length = 20)
    @NotBlank(message = "Name is mandatory")
    private String firstName;

    @ApiModelProperty(example = "Nowak")
    @Column(name = "last_name", length = 30)
    @NotBlank(message = "Name is mandatory")
    private String lastName;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "date_of_birth")
    @NotNull(message = "Date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true, name = "team_id")
    @JsonIgnore
    private Team team;

}
