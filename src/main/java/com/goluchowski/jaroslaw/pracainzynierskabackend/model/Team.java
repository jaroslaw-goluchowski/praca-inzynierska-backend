package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Skra Belchatow")
    @Column(name = "name", length = 40)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ApiModelProperty(example = "Krakow")
    @Column(name = "city", length = 30)
    @NotBlank(message = "City is mandatory")
    private String city;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "creation_date")
    @NotNull(message = "Date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToOne(mappedBy = "team")
    @ApiModelProperty(hidden = true)
    private Trainer trainer;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiModelProperty(hidden = true)
    private Set<Player> players;

}
