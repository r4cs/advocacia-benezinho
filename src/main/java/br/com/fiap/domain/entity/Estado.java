package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TB_ESTADO", uniqueConstraints = {
        @UniqueConstraint(
                name="NM_ESTADO",
                columnNames = "NM_ESTADO"
        ),
        @UniqueConstraint(
                name="UF_ESTADO",
                columnNames = "UF_ESTADO"
        )
})
public class Estado {

    @Id
    @Column(name="ID_ESTADO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(name = "SQ_ESTADO")
    private Long id;

    @Column(name="NM_ESTADO", nullable = false)
    private String nome;

    @Column(name="UF_ESTADO", nullable = false)
    private String sigla;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }


    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
