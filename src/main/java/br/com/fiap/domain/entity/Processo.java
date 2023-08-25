package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TB_PROCESSO", uniqueConstraints = {
        @UniqueConstraint(
                name = "NR_PROCESSO",
                columnNames = {"NR_PROCESSO"})
})

public class Processo {

    @Id
    @Column(name="ID_PROCESSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(name="SQ_PROCESSO")
    private Long id;

    @Column(name="NR_PROCESSO", nullable = false)
    private String numero;

    @Column(name="IS_PBONO")
    private Boolean proBono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ADV",
            referencedColumnName = "ID_ADV",
            foreignKey = @ForeignKey(name = "FK_PCSSO_ADV"),
            nullable = false
    )
    private Advogado advogado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TPACAO",
            referencedColumnName = "ID_TPACAO",
            foreignKey = @ForeignKey(name="FK_PCSSO_ID_TPACAO"),
            nullable = false
    )
    private TipoDeAcao tipoDeAcao;


    public Processo() {
    }

    public Processo(Long id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao) {
        this.id = id;
        this.numero = numero;
        this.proBono = proBono;
        this.advogado = advogado;
        this.tipoDeAcao = tipoDeAcao;
    }

    public Long getId() {
        return id;
    }

    public Processo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Boolean getProBono() {
        return proBono;
    }

    public Processo setProBono(Boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "\nid=" + id +
                ", \nnumero='" + numero + '\'' +
                ", \nproBono=" + proBono +
                ", \nadvogado=" + advogado +
                ", \ntipoDeAcao=" + tipoDeAcao +
                '}';
    }
}
