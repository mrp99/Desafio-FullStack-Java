package br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;

import java.time.LocalDateTime;

public class ComentarioDTO {

    private Long id;
    private String mensagem;
    private String autor;
    private Long pontoTuristicoId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ComentarioDTO() {}

    public ComentarioDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.autor = comentario.getAutor();
        this.mensagem = comentario.getMensagem();
        this.pontoTuristicoId = comentario.getPontoTuristico().getId();
        this.dataCriacao = comentario.getDataCriacao();
        this.dataAtualizacao = comentario.getDataAtualizacao();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}
