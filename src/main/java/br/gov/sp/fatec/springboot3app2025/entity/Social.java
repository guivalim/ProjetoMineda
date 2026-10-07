package br.gov.sp.fatec.springboot3app2025.entity;

import br.gov.sp.fatec.springboot3app2025.controller.View;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "soc_social")
public class Social {

    @Id
    @Column(name = "soc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.SocialView.class)
    private Long id;

    @Column(name = "soc_nome")
    @JsonView(View.SocialView.class)
    private String nome;

    @Column(name = "soc_data_cadastro")
    @JsonView(View.SocialView.class)
    private LocalDate dataCadastro;

    @Column(name = "soc_participacao")
    @JsonView(View.SocialView.class)
    private Double participacao;

    @Column(name = "soc_url")
    @JsonView(View.SocialView.class)
    private String url;

    @ManyToOne
    @JoinColumn(name = "soc_aluno")
    @JsonView(View.SocialView.class)
    private Aluno aluno;

    public Social(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getParticipacao() {
        return participacao;
    }

    public void setParticipacao(Double participacao) {
        this.participacao = participacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    

}
