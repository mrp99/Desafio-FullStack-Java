package br.com.juridico.totvs.fullstack.Backend.controllers;

import br.com.juridico.totvs.fullstack.Backend.services.interfaces.PaisService;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.pais.PaisDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/pais")
public class PaisController {
    private final PaisService paisService;

    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public PaisDTO create(@RequestBody PaisCreateUpdateDTO paisCreateUpdateDTO){
        return this.paisService.create(paisCreateUpdateDTO);
    }

    @GetMapping
    public List<PaisDTO> getAll(){
        return this.paisService.getAllPais();
    }

    @GetMapping("{continente}/continente")
    public List<PaisDTO> getPaisByContinente(@PathVariable String continente){
        return this.paisService.getPaisByContinente(continente);
    }

    @GetMapping("{idPais}")
    public PaisDTO getPaisById(@PathVariable Long idPais){
        return this.paisService.getPaisbyId(idPais);
    }

    @DeleteMapping("{idPais}")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void delete(@PathVariable Long idPais){
        this.paisService.delete(idPais);
    }

    @PutMapping("{idPais}")
    public PaisDTO update(@PathVariable Long idPais,
                          @RequestBody PaisCreateUpdateDTO paisCreateUpdateDTO ){
        return this.paisService.update(idPais, paisCreateUpdateDTO);
    }
}
