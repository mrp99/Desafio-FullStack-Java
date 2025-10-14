package br.com.juridico.totvs.fullstack.Backend.services;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {
    List<Pais> listPais = null;

    PaisServiceImpl(){
        this.listPais = new ArrayList<>();
        this.listPais.add(new Pais(1L,
                "Brasil",
                "BRA",
                "América do sul",
                55));
    }

    @Override
    public PaisDTO create(PaisCreateUpdateDTO paisCreateUpdateDTO) {
        Pais novoPais = new Pais(
                this.getNewId(),
                paisCreateUpdateDTO.getNome(),
                paisCreateUpdateDTO.getSigla(),
                paisCreateUpdateDTO.getContinente(),
                paisCreateUpdateDTO.getDdi());

        this.listPais.add(novoPais);

        return new PaisDTO(novoPais);
    }

    @Override
    public PaisDTO update(Long id, PaisCreateUpdateDTO paisCreateUpdateDTO) {
        Pais pais = this.getPaisById(id);
        int index = this.listPais.indexOf(pais);
        if (pais == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pais.setNome(paisCreateUpdateDTO.getNome());
        pais.setContinente(paisCreateUpdateDTO.getContinente());
        pais.setSigla(paisCreateUpdateDTO.getSigla());
        pais.setDdi(paisCreateUpdateDTO.getDdi());

        this.listPais.set(index, pais);
        return new PaisDTO(pais);
    }

    @Override
    public void delete(Long id) {
        Pais pais = this.getPaisById(id);
        this.listPais.remove(pais);
    }

    @Override
    public PaisDTO getPaisbyId(Long id) {
        Pais pais = this.getPaisById(id);
        if (pais == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new PaisDTO(pais);
    }

    @Override
    public List<PaisDTO> getPaisByContinente(String continente) {
        return this.listPais.stream()
                .filter(x -> x.getContinente().equals(continente))
                .map(pais -> new PaisDTO(pais))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaisDTO> getAllPais() {
        return this.listPais.stream()
                .map(pais -> new PaisDTO(pais))
                .collect(Collectors.toList());
    }

    private Long getNewId(){
        if (this.listPais.size() > 0){
            return this.listPais.stream().max(Comparator
                            .comparingDouble(Pais::getId))
                    .get()
                    .getId()+1;
        } else {
            return Long.valueOf(1);
        }
    }

    private Pais getPaisById(Long id){
        return this.listPais.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElse(null);
    }

    private int getPaisIndexById(Long id){
        AtomicInteger index = new AtomicInteger();
        return this.listPais.stream()
                .peek(p -> index.incrementAndGet())
                .anyMatch(x -> x.getId().equals(id)) ?
                index.get() - 1 : -1;
    }

}
