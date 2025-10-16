package br.com.juridico.totvs.fullstack.Backend.services.dtos.pais;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PaisCreateUpdateDTO {

    @NotBlank(message = "O nome do país é obrigatório")
    private String nome;

    @NotBlank(message = "A sigla do país é obrigatória")
    private String sigla;

    @NotBlank(message = "O continente é obrigatório")
    private String continente;

    @Min(value = 1, message = "O DDI deve ser maior que zero")
    private int ddi;

    public PaisCreateUpdateDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }
}
