package main.java.gradle;
import java.util.Date;

enum Priority {
    BAIXA, NORMAL, ALTA
}

class Tarefa {
    private String assunto;
    private String descricaoDetalhada;
    private Priority prioridade;
    private Date dataInicio;
    private Date dataConclusao;
    private int trabalhoEstimado; // em horas
    private int trabalhoReal; // em horas

    // Construtor
    public Tarefa(String assunto, String descricaoDetalhada, Priority prioridade, Date dataInicio, int trabalhoEstimado) {
        this.assunto = assunto;
        this.descricaoDetalhada = descricaoDetalhada;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.trabalhoEstimado = trabalhoEstimado;
    }

    // Método para definir a conclusão da tarefa
    public void concluirTarefa(Date dataConclusao, int trabalhoReal) {
        this.dataConclusao = dataConclusao;
        this.trabalhoReal = trabalhoReal;
    }

    // Getters e Setters
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public Priority getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Priority prioridade) {
        this.prioridade = prioridade;
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

    public int getTrabalhoEstimado() {
        return trabalhoEstimado;
    }

    public void setTrabalhoEstimado(int trabalhoEstimado) {
        this.trabalhoEstimado = trabalhoEstimado;
    }

    public int getTrabalhoReal() {
        return trabalhoReal;
    }

    public void setTrabalhoReal(int trabalhoReal) {
        this.trabalhoReal = trabalhoReal;
    }

    // Método para verificar se a tarefa está concluída
    public boolean estaConcluida() {
        return this.dataConclusao != null;
    }
}