package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "spotkania")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Spotkania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spotkanie_id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data")
    @NotNull(message = "Date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne(targetEntity = Druzyny.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Druzyny gospodarz;

    @ManyToOne(targetEntity = Druzyny.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Druzyny gosc;

    @ApiModelProperty(example = "3")
    @Column(name = "sety_gospodarze", length = 30)
    @NotBlank(message = "sety_gospodarze is mandatory")
    private int sety_gospodarze;

    @ApiModelProperty(example = "2")
    @Column(name = "sety_goscie", length = 30)
    @NotBlank(message = "sety_goscie is mandatory")
    private int sety_goscie;

}
