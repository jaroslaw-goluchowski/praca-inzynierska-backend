package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @JsonIgnore
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
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @JsonIgnore
    private Team team;

}
