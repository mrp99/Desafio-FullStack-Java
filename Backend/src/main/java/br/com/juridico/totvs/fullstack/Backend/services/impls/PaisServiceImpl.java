package br.com.juridico.totvs.fullstack.Backend.services.impls;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;
import br.com.juridico.totvs.fullstack.Backend.repositories.PaisRepository;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public PaisDTO create(PaisCreateUpdateDTO dto) {
        Pais pais = new Pais();
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());
        pais.setContinente(dto.getContinente());
        pais.setDdi(dto.getDdi());

        Pais saved = paisRepository.save(pais);
        return new PaisDTO(saved);
    }

    @Override
    public PaisDTO update(Long id, PaisCreateUpdateDTO dto) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País não encontrado"));

        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());
        pais.setContinente(dto.getContinente());
        pais.setDdi(dto.getDdi());

        Pais updated = paisRepository.save(pais);
        return new PaisDTO(updated);
    }

    @Override
    public void delete(Long id) {
        paisRepository.deleteById(id);
    }

    @Override
    public PaisDTO getPaisById(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País não encontrado"));
        return new PaisDTO(pais);

    }

    @Override
    public List<PaisDTO> getPaisByContinente(String continente) {
        List<Pais> paises = paisRepository.findByContinenteIgnoreCase(continente);
        return paises.stream().map(PaisDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<PaisDTO> getAll() {
        return paisRepository.findAll().stream()
                .map(PaisDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PontoTuristicoDTO> getPontosTuristicos(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País não encontrado"));

        return pais.getPontosTuristicos().stream()
                .map(PontoTuristicoDTO::new)
                .collect(Collectors.toList());
    }

}
