package com.fullstack.desafio.cursosAdmin.controller;

import com.fullstack.desafio.cursosAdmin.model.AlunoModel;
import com.fullstack.desafio.cursosAdmin.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<AlunoModel> get() {
        return alunoService.buscarTodos();
    }

    @GetMapping("{id}")
    public AlunoModel getId(@PathVariable Integer id) throws Exception {
        return alunoService.buscarPorId(id);
    }

    @PostMapping
    public AlunoModel post(@RequestBody AlunoModel aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

    @PutMapping("{id}")
    public AlunoModel put(@PathVariable Integer id, @RequestBody AlunoModel aluno) throws Exception {
        return alunoService.salvar(id, aluno);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return alunoService.excluir(id);
    }

}
