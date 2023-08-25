package br.com.fiap.domain.entity;

public enum TpAcaoJud {
    AÇÃO_CIVIL(new TipoDeAcao(null, "Ação Civil")),
    AÇÃO_CRIMINAL(new TipoDeAcao(null, "Ação Criminal")),
    AÇÃO_TRABALHISTA(new TipoDeAcao(null, "Ação Trabalhista")),
    AÇÃO_CONSUMIDOR(new TipoDeAcao(null, "Ação do Consumidor")),
    RECURSO_APELACAO(new TipoDeAcao(null, "Recurso de Apelação")),
    RECURSO_REVISAO_CRIMINAL(new TipoDeAcao(null, "Recurso de Revisão Criminal")),
    RECURSO_TRABALHISTA(new TipoDeAcao(null, "Recurso Trabalhista")),
    RECURSO_ESPECIAL(new TipoDeAcao(null, "Recurso Especial")),
    RECURSO_EXTRAORDINARIO(new TipoDeAcao(null, "Recurso Extraordinário")),
    MANDADO_SEGURANCA(new TipoDeAcao(null, "Mandado de Segurança")),
    AÇÃO_DIVORCIO(new TipoDeAcao(null, "Ação de Divórcio")),
    INTERDICAO(new TipoDeAcao(null, "Interdição"));

    private TipoDeAcao tipoDeAcao;

    TpAcaoJud(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }
}