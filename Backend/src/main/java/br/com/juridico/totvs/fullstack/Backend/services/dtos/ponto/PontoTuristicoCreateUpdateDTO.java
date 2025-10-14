package br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto;

public class PontoTuristicoCreateUpdateDTO {

    private String nome;
    private String cidade;
    private String resumo;
    private String melhorEstacao;
    private Long paisId;

    public PontoTuristicoCreateUpdateDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(String melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }


}
