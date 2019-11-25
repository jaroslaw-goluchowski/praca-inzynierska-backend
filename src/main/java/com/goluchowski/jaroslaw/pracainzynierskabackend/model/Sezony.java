package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sezony")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sezony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sezon_id")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long sezon_id;

    @ApiModelProperty(example = "2018/2019")
    @Column(name = "nazwaSezonu", length = 40)
    @NonNull
    private String nazwaSezonu;

    @OneToMany(targetEntity = Spotkania.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "sezon")
    private List<Spotkania> spotkania;

}
