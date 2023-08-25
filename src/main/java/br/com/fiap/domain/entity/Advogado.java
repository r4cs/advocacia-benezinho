package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TB_ADV", uniqueConstraints = {
        @UniqueConstraint(
                name="N_OAB",
                columnNames = "N_OAB")
})
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ADV")
    @SequenceGenerator(name="SQ_ADV")
    @Column(name="ID_ADV")
    private Long id;

    @Column(name="NM_ADV")
    private String nome;

    @Column(name="N_OAB")
    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ESTADO",
            referencedColumnName = "ID_ESTADO",
            foreignKey = @ForeignKey(name="FK_ID_ESTADO"),
            nullable = false
    )
    private Estado estado;


    public Advogado() {
    }

    public Advogado(Long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Advogado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return "Advogado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroOAB='" + numeroOAB + '\'' +
                '}';
    }


}
