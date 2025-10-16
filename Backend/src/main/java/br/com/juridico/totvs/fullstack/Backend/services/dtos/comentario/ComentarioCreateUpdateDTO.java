package br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ComentarioCreateUpdateDTO {

    @NotBlank(message = "O autor do comentário é obrigatório")
    private String autor;

    @NotBlank(message = "A mensagem do comentário é obrigatória")
    private String mensagem;

    @NotNull(message = "O ponto turístico é obrigatório")
    private Long pontoTuristicoId;

    public ComentarioCreateUpdateDTO() {}

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(Long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
