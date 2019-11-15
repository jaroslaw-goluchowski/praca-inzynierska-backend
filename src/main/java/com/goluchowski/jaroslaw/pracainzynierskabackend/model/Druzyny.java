package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "druzyny")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Druzyny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "druzyna_id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Skra Belchatow")
    @Column(name = "nazwa", length = 40)
    @NotBlank(message = "Name is mandatory")
    private String nazwa;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data_zalozenia")
    @NotNull(message = "Date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date data_zalozenia;

    @OneToOne(targetEntity = Miasta.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Miasta miasto;

    @OneToOne(targetEntity = Trenerzy.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ApiModelProperty(hidden = true)
    private Trenerzy trener;
}