package br.com.juridico.totvs.fullstack.Backend.services.interfaces;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;

import java.util.List;

public interface PontoTuristicoService {
    PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO dto);
    PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO dto);
    void delete(Long id);
    PontoTuristicoDTO getById(Long id);
    PontoTuristicoDTO getPontoTuristicoById(Long id);
    List<PontoTuristicoDTO> getPontoTuristicoByPais(Long paisId);
    List<PontoTuristicoDTO> getAllPontoTuristico();
    List<PontoTuristicoDTO> getByPais(Long paisId);
    List<PontoTuristicoDTO> getAll();
}


