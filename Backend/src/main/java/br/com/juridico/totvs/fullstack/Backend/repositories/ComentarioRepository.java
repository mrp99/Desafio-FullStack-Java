package br.com.juridico.totvs.fullstack.Backend.repositories;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
