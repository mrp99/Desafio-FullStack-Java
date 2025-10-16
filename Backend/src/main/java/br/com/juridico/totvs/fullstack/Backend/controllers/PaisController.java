package br.com.juridico.totvs.fullstack.Backend.controllers;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.PaisService;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaisDTO create(@RequestBody PaisCreateUpdateDTO dto) {
        return paisService.create(dto);
    }

    @PutMapping("/{id}")
    public PaisDTO update(@PathVariable Long id, @RequestBody PaisCreateUpdateDTO dto) {
        return paisService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paisService.delete(id);
    }

    @GetMapping("/{id}")
    public PaisDTO getById(@PathVariable Long id) {
        return paisService.getPaisById(id);
    }

    @GetMapping("/continente/{nome}")
    public List<PaisDTO> getByContinente(@PathVariable String nome) {
        return paisService.getPaisByContinente(nome);
    }

    @GetMapping
    public List<PaisDTO> getAll() {
        return paisService.getAll();
    }

    @GetMapping("/{id}/pontos-turisticos")
    public List<PontoTuristicoDTO> getPontosTuristicos(@PathVariable Long id) {
        return paisService.getPontosTuristicos(id);
    }
}
