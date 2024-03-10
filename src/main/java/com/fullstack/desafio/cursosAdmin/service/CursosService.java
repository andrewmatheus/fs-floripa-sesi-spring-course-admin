package com.fullstack.desafio.cursosAdmin.service;

import com.fullstack.desafio.cursosAdmin.model.CursosModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {

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
