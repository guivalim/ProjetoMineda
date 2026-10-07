package br.gov.sp.fatec.springboot3app2025.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springboot3app2025.entity.Social;
import br.gov.sp.fatec.springboot3app2025.service.SocialService;

@RestController
@CrossOrigin
@RequestMapping("/social")
public class SocialController {

private final SocialService service;

    public SocialController(SocialService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.SocialView.class)
    public List<Social> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @JsonView(View.SocialView.class)
    public Social buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @JsonView(View.SocialView.class)
    public ResponseEntity<Social> cadastrar(@RequestBody Social social) {
        Social socialCadastrada = service.cadastrar(social);
        return ResponseEntity.created(URI.create("/social/" + socialCadastrada.getId())).body(socialCadastrada);
    }

    @GetMapping("/buscar")
    @JsonView(View.SocialView.class)
    public List<Social> buscarPorRaEData(
            @RequestParam("ra") Long ra, 
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return service.buscarPorRaEData(ra, data);
    }
}