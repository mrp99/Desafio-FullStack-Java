package br.com.juridico.totvs.fullstack.Backend.services.interfaces;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioDTO;

import java.util.List;

public interface ComentarioService {
    ComentarioDTO create(ComentarioCreateUpdateDTO dto);
    ComentarioDTO update(Long id, ComentarioCreateUpdateDTO dto);
    void delete(Long id);
    ComentarioDTO getComentarioById(Long id);
    List<ComentarioDTO> getComentariosByPontoTuristico(Long pontoId);
    List<ComentarioDTO> getAllComentarios();
}
