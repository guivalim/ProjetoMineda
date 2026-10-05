package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import br.gov.sp.fatec.springboot3app2025.entity.Curso;

public interface CursoService {
    public Curso buscarPorId(Long id);
    public Curso cadastrar(Curso curso);
    public List<Curso> buscarTodos();
}