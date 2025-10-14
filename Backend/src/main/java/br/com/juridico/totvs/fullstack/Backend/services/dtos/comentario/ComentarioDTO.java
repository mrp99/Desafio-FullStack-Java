package br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ComentarioDTO {

    private Long id;

    @NotBlank(message = "A mensagem do comentário é obrigatória")
    private String mensagem;

    private String autor;

    @NotNull(message = "O ponto turístico é obrigatório")
    private Long pontoTuristicoId;

    private LocalDateTime dataCriacao;

    public ComentarioDTO() {}


    public ComentarioDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.mensagem = comentario.getMensagem();
        this.autor = comentario.getAutor();
        this.pontoTuristicoId = comentario.getPontoTuristico().getId();
        this.dataCriacao = comentario.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(Long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
