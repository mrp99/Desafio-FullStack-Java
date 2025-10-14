package br.com.juridico.totvs.fullstack.Backend.services;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaisService {
    List<Pais> listPais = null;
    public PaisDTO create(PaisCreateUpdateDTO paisCreateUpdateDTO);
    public PaisDTO update(Long id, PaisCreateUpdateDTO paisCreateUpdateDTO);
    public void delete(Long id);
    public PaisDTO getPaisbyId(Long id);
    public List<PaisDTO> getPaisByContinente(String continente);
    public List<PaisDTO> getAllPais();
}
