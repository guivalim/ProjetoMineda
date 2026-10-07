package br.gov.sp.fatec.springboot3app2025.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3app2025.entity.Social;

public interface SocialRepository extends JpaRepository<Social, Long> {

    
    public List<Social> findByAlunoRaAndDataCadastroGreaterThan(Long ra, LocalDate dataCadastro);

    @Query("SELECT s FROM Social s JOIN s.aluno a WHERE a.ra = :ra AND s.dataCadastro > :data")
    public List<Social> buscarPorRaAlunoEDataPosterior(Long ra, LocalDate data);

}