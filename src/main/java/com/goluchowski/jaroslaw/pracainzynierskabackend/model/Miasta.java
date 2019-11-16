package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "miasta")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Miasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miasto_id")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Long miasto_id;

    @ApiModelProperty(example = "Koszalin")
    @Column(name = "nazwa", length = 40)
    @NotBlank(message = "Name is mandatory")
    @NonNull
    private String nazwa;
}
