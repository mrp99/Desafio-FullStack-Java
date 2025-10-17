package br.com.juridico.totvs.fullstack.Backend.services.impls;

import br.com.juridico.totvs.fullstack.Backend.domains.Pais;
import br.com.juridico.totvs.fullstack.Backend.domains.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.excptions.RecursoNaoEncontradoException;
import br.com.juridico.totvs.fullstack.Backend.repositories.PaisRepository;
import br.com.juridico.totvs.fullstack.Backend.repositories.PontoTuristicoRepository;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;
import br.com.juridico.totvs.fullstack.Backend.services.interfaces.PontoTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {

    @Autowired
    private PontoTuristicoRepository pontoRepository;

    @Autowired
    private PaisRepository paisRepository;


    @Override
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO dto) {
        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "País com ID " + dto.getPaisId() + " não encontrado")
                );

        PontoTuristico ponto = new PontoTuristico();
        ponto.setNome(dto.getNome());
        ponto.setCidade(dto.getCidade());
        ponto.setResumo(dto.getResumo());
        ponto.setMelhorEstacao(dto.getMelhorEstacao());
        ponto.setPais(pais);

        PontoTuristico saved = pontoRepository.save(ponto);
        return new PontoTuristicoDTO(saved);
    }

    @Override
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO dto) {
        PontoTuristico ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Ponto turístico com ID "
                                + id
                                + " não encontrado")
                );

        Pais pais = paisRepository.findById(dto.getPaisId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "País com ID "
                                + dto.getPaisId()
                                + " não encontrado")
                );

        ponto.setNome(dto.getNome());
        ponto.setCidade(dto.getCidade());
        ponto.setResumo(dto.getResumo());
        ponto.setMelhorEstacao(dto.getMelhorEstacao());
        ponto.setPais(pais);

        PontoTuristico updated = pontoRepository.save(ponto);
        return new PontoTuristicoDTO(updated);
    }

    @Override
    public void delete(Long id) {
        PontoTuristico ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Ponto turístico com ID "
                                + id
                                + " não encontrado"));
        pontoRepository.delete(ponto);
    }

    @Override
    public PontoTuristicoDTO getById(Long id) {
        PontoTuristico ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Ponto turístico com ID "
                                + id
                                + " não encontrado"));
        return new PontoTuristicoDTO(ponto);
    }

    @Override
    public List<PontoTuristicoDTO> getByPais(Long paisId) {
        if (!paisRepository.existsById(paisId)) {
            throw new RecursoNaoEncontradoException(
                    "País com ID "
                            + paisId
                            + " não encontrado");
        }

        List<PontoTuristico> pontos = pontoRepository.findByPaisId(paisId);
        return pontos.stream().map(PontoTuristicoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PontoTuristicoDTO> getAll() {
        return pontoRepository.findAll()
                .stream().map(PontoTuristicoDTO::new)
                .collect(Collectors.toList());
    }
}
