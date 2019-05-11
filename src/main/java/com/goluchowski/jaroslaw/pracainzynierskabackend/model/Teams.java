package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teams {

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

    @OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Trainers.class, mappedBy = "teams")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Trainers trainer;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Players.class, mappedBy = "teams", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Players> players;
}
