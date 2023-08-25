package br.com.fiap.domain.entity;

public enum UfBrasileiras {
    AC(new Estado(null, "AC", "Acre")),
    AL(new Estado(null, "AL", "Alagoas")),
    AM(new Estado(null, "AM", "Amazonas")),
    AP(new Estado(null, "AP", "Amapá")),
    BA(new Estado(null, "BA", "Bahia")),
    CE(new Estado(null, "CE", "Ceará")),
    DF(new Estado(null, "DF", "Distrito Federal")),
    ES(new Estado(null, "ES", "Espírito Santo")),
    GO(new Estado(null, "GO", "Goiás")),
    MA(new Estado(null, "MA", "Maranhão")),
    MG(new Estado(null, "MG", "Minas Gerais")),
    MS(new Estado(null, "MS", "Mato Grosso do Sul")),
    MT(new Estado(null, "MT", "Mato Grosso")),
    PA(new Estado(null, "PA", "Pará")),
    PB(new Estado(null, "PB", "Paraíba")),
    PE(new Estado(null, "PE", "Pernambuco")),
    PI(new Estado(null, "PI", "Piauí")),
    PR(new Estado(null, "PR", "Paraná")),
    RJ(new Estado(null, "RJ", "Rio de Janeiro")),
    RN(new Estado(null, "RN", "Rio Grande do Norte")),
    RO(new Estado(null, "RO", "Rondônia")),
    RR(new Estado(null, "RR", "Roraima")),
    RS(new Estado(null, "RS", "Rio Grande do Sul")),
    SC(new Estado(null, "SC", "Santa Catarina")),
    SE(new Estado(null, "SE", "Sergipe")),
    SP(new Estado(null, "SP", "São Paulo")),
    TO(new Estado(null, "TO", "Tocantins"));

    private Estado estado;

    UfBrasileiras(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
