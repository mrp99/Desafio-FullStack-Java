package br.com.juridico.totvs.fullstack.Backend.domains;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do país é obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank(message = "A sigla é obrigatória")
    @Column(length = 3)
    private String sigla;

    @NotBlank(message = "O continente é obrigatório")
    private String continente;

    @Min(value = 1, message = "DDI deve ser maior que zero")
    private int ddi;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PontoTuristico> pontosTuristicos = new ArrayList<>();

    public Pais() {}

    public Pais(Long id, String nome, String sigla, String continente, int ddi){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.continente = continente;
        this.ddi = ddi;
    }

    public Pais(PaisDTO paisDTO){
        this.id = paisDTO.getId();
        this.nome = paisDTO.getNome();
        this.sigla = paisDTO.getSigla();
        this.continente = paisDTO.getContinente();
        this.ddi = paisDTO.getDdi();
    }

    public Long getId() {
        return id;
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

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public List<PontoTuristico> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(List<PontoTuristico> pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }
}
