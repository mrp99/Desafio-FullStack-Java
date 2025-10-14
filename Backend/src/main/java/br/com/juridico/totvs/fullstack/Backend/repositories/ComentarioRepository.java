package br.com.juridico.totvs.fullstack.Backend.repositories;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPontoTuristicoId(Long pontoTuristicoId);
}
