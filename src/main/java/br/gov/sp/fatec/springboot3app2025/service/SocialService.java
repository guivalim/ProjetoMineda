package br.gov.sp.fatec.springboot3app2025.service;

import java.time.LocalDate;
import java.util.List;

import br.gov.sp.fatec.springboot3app2025.entity.Social;

public interface SocialService {
    public List<Social> buscarTodos();
    public Social cadastrar(Social social);
    public Social buscarPorId(Long id);
    public List<Social> buscarPorRaEData(Long ra, LocalDate data);
}

