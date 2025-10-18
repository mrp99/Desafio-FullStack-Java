package br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto;

import br.com.juridico.totvs.fullstack.Backend.domains.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.domains.enums.Estacoes;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PontoTuristicoDTO {

    private Long id;

    // Entrada (POST/PUT)
    private String nome;
    private String cidade;
    private String resumo;
    private String melhorEstacao;
    private Long paisId;

    // Saída (GET)
    private PaisDTO pais;
    private List<ComentarioDTO> comentarios;

    public PontoTuristicoDTO() {}

    // Construtor para resposta (GET)
    public PontoTuristicoDTO(PontoTuristico pt) {
        this.id = pt.getId();
        this.nome = pt.getNome();
        this.cidade = pt.getCidade();
        this.resumo = pt.getResumo();
        this.melhorEstacao = pt.getMelhorEstacao();
        this.paisId = pt.getPais().getId();
        this.pais = new PaisDTO(pt.getPais());
        this.comentarios = pt.getComentarios().stream()
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }

    //Getters e Setters
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

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
