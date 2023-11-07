package main.java.gradle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Atividade {
    private String titulo;
    private boolean estado;
    private Date dataInicio;
    private Date dataConclusao;
    private List<Tarefa> tarefas = new ArrayList<>();

    // Construtor
    public Atividade(String titulo) {
        this.titulo = titulo;
        this.estado = false;
    }

    // Método para verificar se todas as tarefas foram concluídas
    public void verificarEstado(Tarefa[] tarefas) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDataConclusao() == null) {
                this.estado = false;
                return;
            }
        }
        this.estado = true;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEstado() {
        return estado;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    // Método para adicionar uma nova tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    // Método para remover uma tarefa
    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    // Método para listar todas as tarefas
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefasOrdenadasPorData = new ArrayList<>(tarefas);
        Collections.sort(tarefasOrdenadasPorData, Comparator.comparing(Tarefa::getDataInicio));
        return tarefasOrdenadasPorData;
    }

    // Método para listar tarefas pendentes
    public List<Tarefa> listarTarefasPendentes() {
        List<Tarefa> tarefasPendentes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.estaConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }
}