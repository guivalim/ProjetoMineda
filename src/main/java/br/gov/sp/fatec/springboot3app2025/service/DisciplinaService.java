package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import br.gov.sp.fatec.springboot3app2025.entity.Disciplina;

public interface DisciplinaService {
    public Disciplina cadastrar(Disciplina disciplina);
    public Disciplina buscarPorId(Long id);
    public List<Disciplina> buscarTodos();
    public void matricularAluno(Long disciplinaId, Long alunoId);
}
