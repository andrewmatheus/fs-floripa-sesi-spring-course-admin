package com.fullstack.desafio.cursosAdmin.service;

import com.fullstack.desafio.cursosAdmin.model.AlunoModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AlunoService {

    public List<AlunoModel> buscarTodos() {
        return AlunoModel.getAlunos();
    }

    public AlunoModel buscarPorId(Integer id) throws Exception {
        return AlunoModel.buscarPorId(id);
    }

    public AlunoModel salvar(AlunoModel aluno) throws Exception {
        if (validarAluno(aluno)) {
            return AlunoModel.inserir(aluno);
        }
        return null;
    }

    private boolean validarAluno(AlunoModel aluno) throws Exception {
        if (!StringUtils.hasText(aluno.getNome())) {
            throw new Exception("Nome é obrigatório!");
        }

        if (aluno.getDataNascimento() == null) {
            throw new Exception("Data de nascimento é obrigatório!");
        }

        return true;
    }
}
