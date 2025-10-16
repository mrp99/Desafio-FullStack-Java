package br.com.juridico.totvs.fullstack.Backend.services.interfaces;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;

import java.util.List;


public interface PaisService {

    public PaisDTO create(PaisCreateUpdateDTO paisCreateUpdateDTO);
    public PaisDTO update(Long id, PaisCreateUpdateDTO paisCreateUpdateDTO);
    public void delete(Long id);
    public PaisDTO getPaisById(Long id);
    public List<PaisDTO> getPaisByContinente(String continente);
    public List<PaisDTO> getAll();
    List<PontoTuristicoDTO> getPontosTuristicos(Long id);
}
