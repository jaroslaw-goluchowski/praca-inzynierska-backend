package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
    @JsonIgnore
    private Long druzyna_id;

    @ApiModelProperty(example = "Skra Belchatow")
    @Column(name = "nazwa", length = 40)
    @NotBlank(message = "Name is mandatory")
    private String nazwa;

    @ApiModelProperty(example = "1996-09-06")
    @Column(name = "data_zalozenia")
    @NotNull(message = "Date is mandatory")
    private Long data_zalozenia;

    @Column(name = "zdjecie_druzynowe")
    @Lob
    @JsonIgnore
    private byte[] zdjecie_druzynowe;

    @Column(name = "logo")
    @Lob
    @JsonIgnore
    private byte[] logo;

    @OneToOne(targetEntity = Miasta.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Miasta miasto;

    @OneToOne(targetEntity = Trenerzy.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ApiModelProperty(hidden = true)
    private Trenerzy trener;
}