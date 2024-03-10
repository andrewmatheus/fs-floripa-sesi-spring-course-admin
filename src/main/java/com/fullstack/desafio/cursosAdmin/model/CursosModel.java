package com.fullstack.desafio.cursosAdmin.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CursosModel {
    private static Integer proximoId = 1;
    @Getter private static List<CursosModel> cursos = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;

    private static Integer getProximoId() {
        return proximoId++;
    }

    public static CursosModel inserir(CursosModel curso) {
        curso.id = getProximoId();
        cursos.add(curso);
        return curso;
    }

    public static CursosModel buscarPorId(Integer id) throws Exception {
        for (CursosModel curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    public static boolean excluir(CursosModel curso) {
        cursos.remove(curso);
        return true;
    }

}
