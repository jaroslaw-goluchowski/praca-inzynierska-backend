package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trenerzy")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trenerzy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trener_id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "Artur")
    @Column(name = "imie", length = 20)
    @NotBlank(message = "Name is mandatory")
    private String imie;

    @ApiModelProperty(example = "Nowak")
    @Column(name = "nazwisko", length = 30)
    @NotBlank(message = "Name is mandatory")
    private String nazwisko;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data_urodzenia")
    @NotNull(message = "Date is mandatory")
    @Temporal(TemporalType.DATE)
    private Date data_urodzenia;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(unique = true, name = "team_id")
//    @JsonIgnore
//    private Druzyny druzyny;

}
