package com.goluchowski.jaroslaw.pracainzynierskabackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "punkty")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PunktyNaSpotkanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "punkty_id")
    @ApiModelProperty(hidden = true)
//    @JsonIgnore
    private Long punkty_id;

    @ManyToOne(targetEntity = Spotkania.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "spotkanie_id")
    private Spotkania spotkanie;

    @ManyToOne(targetEntity = Siatkarze.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "siatkarz_id")
    private Siatkarze siatkarz;

    @Column(name = "punkty")
    private int punkty;
}
