package br.com.juridico.totvs.fullstack.Backend.controllers;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.PontoTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pontos-turisticos")
public class PontoTuristicoController {

    @Autowired
    private PontoTuristicoService pontoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontoTuristicoDTO create(@RequestBody PontoTuristicoCreateUpdateDTO dto) {
        return pontoService.create(dto);
    }

    @PutMapping("/{id}")
    public PontoTuristicoDTO update(@PathVariable Long id, @RequestBody PontoTuristicoCreateUpdateDTO dto) {
        return pontoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        pontoService.delete(id);
    }

    @GetMapping("/{id}")
    public PontoTuristicoDTO getById(@PathVariable Long id) {
        return pontoService.getPontoTuristicoById(id);
    }

    @GetMapping("/pais/{paisId}")
    public List<PontoTuristicoDTO> getByPais(@PathVariable Long paisId) {
        return pontoService.getPontoTuristicoByPais(paisId);
    }

    @GetMapping
    public List<PontoTuristicoDTO> getAll() {
        return pontoService.getAllPontoTuristico();
    }
}
