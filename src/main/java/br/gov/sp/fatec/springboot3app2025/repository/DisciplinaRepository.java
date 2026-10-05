package br.gov.sp.fatec.springboot3app2025.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3app2025.entity.Disciplina; 

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    // 1. Busca por código exato (Query Method vs @Query)
    public Optional<Disciplina> findByCodigo(String codigo);

    @Query("SELECT d FROM Disciplina d WHERE d.codigo = :codigo")
    public Optional<Disciplina> buscarPeloCodigo(String codigo);

    // 2. Busca por parte do código ou nome (ignorando maiúsculas/minúsculas)
    public List<Disciplina> findByCodigoContainingIgnoreCaseOrNomeContainingIgnoreCase(String codigo, String nome);

    @Query("SELECT d FROM Disciplina d WHERE lower(d.codigo) LIKE lower(%:codigo%) OR lower(d.nome) LIKE lower(%:nome%)")
    public List<Disciplina> buscarPorCodigoOuNome(String codigo, String nome);

    // 3. Busca de disciplinas associadas a um curso através da sigla do curso (Join implícito vs explícito)
    public List<Disciplina> findByCursoSigla(String sigla);

    @Query("SELECT d FROM Disciplina d JOIN d.curso c WHERE c.sigla = :sigla")
    public List<Disciplina> buscarPorSiglaCurso(String sigla);

    // 4. Busca de disciplinas associadas a um aluno através do RA do aluno
    public List<Disciplina> findByAlunosRa(Long ra);

    @Query("SELECT d FROM Disciplina d JOIN d.alunos a WHERE a.ra = :ra")
    public List<Disciplina> buscarPorRaAluno(Long ra);

}