package br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto;

import br.com.juridico.totvs.fullstack.Backend.domains.enums.Estacoes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PontoTuristicoCreateUpdateDTO {

    @NotBlank(message = "O nome do ponto turístico é obrigatório")
    private String nome;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O resumo é obrigatório")
    private String resumo;

    @NotNull(message = "A estação ideal é obrigatória")
    private Estacoes melhorEstacao;

    @NotNull(message = "O país é obrigatório")
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

    public Estacoes getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(Estacoes melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }


}
