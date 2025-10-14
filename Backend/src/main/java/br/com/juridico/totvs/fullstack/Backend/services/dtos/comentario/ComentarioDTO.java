package br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;

public class ComentarioDTO {

    private Long id;
    private String autor;
    private String mensagem;

    public ComentarioDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.autor = comentario.getAutor();
        this.mensagem = comentario.getMensagem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
