package com.cristsky.todo;


public class TarefaModelo {
    private String descricao;
    private boolean isExecutado;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExecutado() {
        return isExecutado;
    }

    public void setExecutado(boolean executado) {
        isExecutado = executado;
    }
}
