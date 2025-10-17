package br.com.juridico.totvs.fullstack.Backend.controllers;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioDTO create(@RequestBody ComentarioCreateUpdateDTO dto) {
        return comentarioService.create(dto);
    }

    @PutMapping("/{id}")
    public ComentarioDTO update(@PathVariable Long id, @RequestBody ComentarioCreateUpdateDTO dto) {
        return comentarioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        comentarioService.delete(id);
    }

    @GetMapping("/{id}")
    public ComentarioDTO getById(@PathVariable Long id) {
        return comentarioService.getComentarioById(id);
    }

    @GetMapping("/ponto-turistico/{pontoId}")
    public List<ComentarioDTO> getByPonto(@PathVariable Long pontoId) {
        return comentarioService.getComentariosByPontoTuristico(pontoId);
    }

    @GetMapping
    public List<ComentarioDTO> getAll() {
        return comentarioService.getAllComentarios();
    }
}
