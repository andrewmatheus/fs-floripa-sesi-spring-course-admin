package com.fullstack.desafio.cursosAdmin.service;

import com.fullstack.desafio.cursosAdmin.model.AlunoModel;
import com.fullstack.desafio.cursosAdmin.model.CursosModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {

    private final AlunoService alunoService;

    public CursosService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<CursosModel> buscarTodos() {
        return CursosModel.getCursos();
    }

    public CursosModel buscarPorId(Integer id) throws Exception {
        return CursosModel.buscarPorId(id);
    }

    public CursosModel salvar(CursosModel curso) throws Exception {
        if (!validarCurso(curso)) {
            return null;
        }
        return CursosModel.inserir(curso);
    }

    public CursosModel salvar(Integer id, CursosModel curso) throws Exception {
        if (validarCurso(curso)) {
            CursosModel cadastrado = buscarPorId(id);
            cadastrado.setNome(curso.getNome());
            cadastrado.setDescricao(curso.getDescricao());
            cadastrado.setCargaHoraria(curso.getCargaHoraria());

            return cadastrado;
        }
        return null;
    }

    public boolean excluir(Integer id) throws Exception {
        CursosModel curso = buscarPorId(id);
        return CursosModel.excluir(curso);
    }

    public CursosModel matricular(Integer id, Integer alunoId) throws Exception {
        CursosModel curso = buscarPorId(id);
        AlunoModel aluno = alunoService.buscarPorId(alunoId);
        CursosModel.matricular(curso, aluno);
        return curso;
    }

    private boolean validarCurso(CursosModel curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório!");
        }

        if (curso.getCargaHoraria() == null) {
            throw new Exception("Carga horária é obrigatório!");
        }

        return true;
    }
}
