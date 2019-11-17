package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
//    @JsonIgnore
    private Long spotkanie_id;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data")
    @NotNull(message = "Date is mandatory")
    private Long data;

    @ManyToOne(targetEntity = Druzyny.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gospodarz_id")
    private Druzyny gospodarz;

    @ManyToOne(targetEntity = Druzyny.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gosc_id")
    private Druzyny gosc;

    @ApiModelProperty(example = "3")
    @Column(name = "sety_gospodarze", length = 30)
    @NotBlank(message = "sety_gospodarze is mandatory")
    private int sety_gospodarze;

    @ApiModelProperty(example = "2")
    @Column(name = "sety_goscie", length = 30)
    @NotBlank(message = "sety_goscie is mandatory")
    private int sety_goscie;

    @ManyToOne(targetEntity = Sedziowie.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sedzia_id")
    private Sedziowie sedzia_spotkania;

    @ManyToOne(targetEntity = Miasta.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "miasto_id")
    private Miasta miasto_spotkania;

}
