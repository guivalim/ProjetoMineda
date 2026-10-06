package br.gov.sp.fatec.springboot3app2025.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springboot3app2025.entity.Aluno;
import br.gov.sp.fatec.springboot3app2025.service.AlunoService;


@RestController
@CrossOrigin
@RequestMapping(value = "/aluno")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.AlunoView.class)
    public List<Aluno> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.AlunoView.class)
    public Aluno buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @JsonView(View.AlunoView.class)
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return service.cadastrar(aluno);
    }
}
