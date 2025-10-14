package br.com.juridico.totvs.fullstack.Backend.repositories;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    List<Pais> findByContinenteIgnoreCase(String continente);
}
