package br.gov.sp.fatec.springboot3app2025.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app2025.entity.Aluno;
import br.gov.sp.fatec.springboot3app2025.entity.Social;
import br.gov.sp.fatec.springboot3app2025.repository.SocialRepository;
import jakarta.transaction.Transactional;

@Service 
public class SocialServiceImpl implements SocialService {

    private final SocialRepository repo;
    private final AlunoService alunoService;

    public SocialServiceImpl(SocialRepository repo, AlunoService alunoService) {
        this.repo = repo;
        this.alunoService = alunoService;
    }

    @Override
    public List<Social> buscarTodos() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Social cadastrar(Social social) {
        if (social == null ||
            social.getId() != null ||
            social.getNome() == null ||
            social.getNome().isBlank() ||
            social.getUrl() == null ||
            social.getUrl().isBlank() ||
            social.getAluno() == null ||
            social.getAluno().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados da rede social inválidos!");
        }
        
        if (social.getDataCadastro() == null) {
            social.setDataCadastro(LocalDate.now());
        }

        if (social.getParticipacao() != null && (social.getParticipacao() < 0.0 || social.getParticipacao() > 1.0)) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A participação deve estar entre 0 e 1!");
        }

        Aluno aluno = alunoService.buscarPorId(social.getAluno().getId());
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno não encontrado!");
        }
        
        social.setAluno(aluno);
        return repo.save(social);
    }

    @Override
    public Social buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido!");
        }
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rede social não encontrada!"));
    }
    
    @Override 
    public List<Social> buscarPorRaEData(Long ra, LocalDate data) {
        if (ra == null || ra <= 0 || data == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parâmetros inválidos!");
        }
        return repo.buscarPorRaAlunoEDataPosterior(ra, data);
    }
}