package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ApiModelProperty(example = "Skra Belchatow")
    @Column(name = "name", length = 40)
    @NotBlank
    private String name;

    @ApiModelProperty(example = "Krakow")
    @Column(name = "city", length = 30)
    @NotBlank
    private String city;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "creation_date")
    private Date creationDate;

    @OneToOne(mappedBy = "team")
    private Trainer trainer;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Player> players;

}
