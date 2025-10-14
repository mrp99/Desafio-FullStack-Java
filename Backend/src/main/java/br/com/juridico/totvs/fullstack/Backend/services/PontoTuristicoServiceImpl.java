package br.com.juridico.totvs.fullstack.Backend.services;

import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.services.dtos.ponto.PontoTuristicoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {


    @Override
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO dto) {
        return null;
    }

    @Override
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PontoTuristicoDTO getById(Long id) {
        return null;
    }

    @Override
    public List<PontoTuristicoDTO> getByPais(Long paisId) {
        return List.of();
    }

    @Override
    public List<PontoTuristicoDTO> getAll() {
        return List.of();
    }
}
