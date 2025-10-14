package br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario;

public class ComentarioCreateUpdateDTO {

    private String autor;
    private String mensagem;
    private Long pontoTuristicoId;

    public ComentarioCreateUpdateDTO() {
    }

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
