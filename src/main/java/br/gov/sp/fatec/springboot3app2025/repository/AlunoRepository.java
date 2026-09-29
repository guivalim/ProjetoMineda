package br.gov.sp.fatec.springboot3app2025.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import br.gov.sp.fatec.springboot3app2025.entity.Aluno; 

public interface AlunoRepository extends JpaRepository<Aluno, Long>{   
}
