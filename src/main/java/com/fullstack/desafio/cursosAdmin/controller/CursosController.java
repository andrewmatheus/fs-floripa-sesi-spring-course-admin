package com.fullstack.desafio.cursosAdmin.controller;

import com.fullstack.desafio.cursosAdmin.model.AlunoModel;
import com.fullstack.desafio.cursosAdmin.model.CursosModel;
import com.fullstack.desafio.cursosAdmin.service.CursosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursosController {
    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @GetMapping
    public List<CursosModel> get() {
        return cursosService.buscarTodos();
    }

    @GetMapping("{id}")
    public CursosModel getId(@PathVariable Integer id) throws Exception {
        return cursosService.buscarPorId(id);
    }

    @PostMapping
    public CursosModel post(@RequestBody CursosModel cursos) throws Exception {
        return cursosService.salvar(cursos);
    }

    @PutMapping("{id}")
    public CursosModel put(@PathVariable Integer id, @RequestBody CursosModel curso) throws Exception {
        return cursosService.salvar(id, curso);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return cursosService.excluir(id);
    }

    @PostMapping("{id}/add-aluno")
    public CursosModel post(@PathVariable Integer id, @RequestBody AlunoModel aluno) throws Exception {
        return cursosService.matricular(id, aluno.getId());
    }

}
