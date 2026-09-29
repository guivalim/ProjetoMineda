package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app2025.entity.Aluno;
import br.gov.sp.fatec.springboot3app2025.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repo;

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> alunoOp = repo.findById(id);
        if (alunoOp.isPresent()) {
            return alunoOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id inválido!");
    }

    public Aluno cadastrar(Aluno aluno) {
        if (aluno == null ||
            aluno.getRa() == null ||
            aluno.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return repo.save(aluno);
    }

    public List<Aluno> buscarTodos() {
        return repo.findAll();
    }
}

