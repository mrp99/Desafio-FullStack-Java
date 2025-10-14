package br.com.juridico.totvs.fullstack.Backend.domains;

import br.com.juridico.totvs.fullstack.Backend.domains.enums.Estacoes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ponto_turistico")
public class PontoTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do ponto turístico é obrigatório")
    @Column(nullable = false)
    private String nome;

    private String cidade;
    private String resumo;

    @Enumerated(EnumType.STRING)
    private Estacoes melhorEstacao;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "pontoTuristico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    public PontoTuristico() {}

    public PontoTuristico(Long id, String nome, String cidade, String resumo, Estacoes melhorEstacao, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.resumo = resumo;
        this.melhorEstacao = melhorEstacao;
        this.pais = pais;
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

    public Estacoes getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(Estacoes melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

}
