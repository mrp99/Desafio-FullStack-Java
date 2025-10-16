package br.com.juridico.totvs.fullstack.Backend.services.impls;

import br.com.juridico.totvs.fullstack.Backend.domains.Comentario;
import br.com.juridico.totvs.fullstack.Backend.domains.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.repositories.ComentarioRepository;
import br.com.juridico.totvs.fullstack.Backend.repositories.PontoTuristicoRepository;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.comentario.ComentarioDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;


    @Override
    public ComentarioDTO create(ComentarioCreateUpdateDTO dto) {
        PontoTuristico ponto = pontoTuristicoRepository.findById(dto.getPontoTuristicoId())
                .orElseThrow(() -> new RuntimeException("Ponto turístico não encontrado"));

        Comentario comentario = new Comentario(
                dto.getAutor(),
                dto.getMensagem(),
                ponto
        );

        comentarioRepository.save(comentario);
        return new ComentarioDTO(comentario);
    }

    @Override
    public ComentarioDTO update(Long id, ComentarioCreateUpdateDTO dto) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));

        comentario.setAutor(dto.getAutor());
        comentario.setMensagem(dto.getMensagem());

        PontoTuristico ponto = pontoTuristicoRepository.findById(dto.getPontoTuristicoId())
                .orElseThrow(() -> new RuntimeException("Ponto turístico não encontrado"));

        comentario.setPontoTuristico(ponto);

        comentarioRepository.save(comentario);
        return new ComentarioDTO(comentario);
    }

    @Override
    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public ComentarioDTO getComentarioById(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
        return new ComentarioDTO(comentario);
    }

    @Override
    public List<ComentarioDTO> getComentariosByPontoTuristico(Long pontoTuristicoId) {
        List<Comentario> comentarios = comentarioRepository.findByPontoTuristicoId(pontoTuristicoId);
        return comentarios.stream().map(ComentarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> getAllComentarios() {
        return comentarioRepository.findAll().stream()
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }
}
