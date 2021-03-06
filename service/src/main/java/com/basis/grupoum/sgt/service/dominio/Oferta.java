package com.basis.grupoum.sgt.service.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "OFERTA")
public class Oferta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OFERTA")
    @SequenceGenerator(name = "SEQ_OFERTA", allocationSize = 1, sequenceName = "SEQ_OFERTA")
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ITEM")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SITUACAO")
    private Situacao situacao;

    @ManyToMany
    @JoinTable(name = "ITEM_OFERTADO", joinColumns =
            {@JoinColumn(name = "ID_OFERTA")}, inverseJoinColumns =
            {@JoinColumn(name = "ID_ITEM")})
    private List<Item> itensOfertados;

}
