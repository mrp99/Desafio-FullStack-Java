package br.com.juridico.totvs.fullstack.Backend.repositories;

import br.com.juridico.totvs.fullstack.Backend.domains.PontoTuristico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Long> {

    List<PontoTuristico> findByPaisId(Long paisId);
}
