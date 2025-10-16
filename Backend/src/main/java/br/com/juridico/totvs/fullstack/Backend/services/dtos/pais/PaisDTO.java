package br.com.juridico.totvs.fullstack.Backend.services.dtos.pais;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PaisDTO {

    private Long id;

    @NotBlank(message = "O nome do país é obrigatório")
    private String nome;

    @NotBlank(message = "A sigla do país é obrigatória")
    private String sigla;

    @NotBlank(message = "O continente é obrigatório")
    private String continente;

    @Min(value = 1, message = "O DDI deve ser maior que zero")
    private int ddi;

    public PaisDTO() {}

    public PaisDTO(Long id, String nome, String sigla, String continente, int ddi){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.continente = continente;
        this.ddi = ddi;
    }

    public PaisDTO(Pais pais){
        this.id = pais.getId();
        this.nome = pais.getNome();
        this.continente = pais.getContinente();
        this.sigla = pais.getSigla();
        this.ddi = pais.getDdi();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setDdd(int ddi) {
        this.ddi = ddi;
    }
}
