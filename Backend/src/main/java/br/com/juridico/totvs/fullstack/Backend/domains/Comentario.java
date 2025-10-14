package br.com.juridico.totvs.fullstack.Backend.domains;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    @NotBlank(message = "O comentário não pode estar vazio")
    @Column(nullable = false)
    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ponto_turistico_id", nullable = false)
    private PontoTuristico pontoTuristico;


    public Comentario() {}

    public Comentario(String autor, String mensagem, LocalDateTime dataCriacao, PontoTuristico pontoTuristico) {
        this.autor = autor;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.pontoTuristico = pontoTuristico;
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

    public void setMensagem (String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }
}
