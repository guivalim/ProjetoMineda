package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;

import br.gov.sp.fatec.springboot3app2025.entity.Trabalho;

public interface TrabalhoService {

    public List<Trabalho> buscarTodos();

    public Trabalho cadastrar(Trabalho trabalho);

    public List<Trabalho> buscarPorRaAlunoETitulo(Long ra, String titulo);

}
