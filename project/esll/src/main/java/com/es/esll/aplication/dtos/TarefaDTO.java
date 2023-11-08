package main.java.com.es.esll.aplication.dtos;

public class TarefaDTO {
    private String assunto;
    private String descricaoDetalhada;
    private String prioridade;
    private Date dataInicio;
    private Date dataConclusao;
    private int trabalhoEstimado;
    private int trabalhoReal;

    // Construtor
    public TarefaDTO(String assunto, String descricaoDetalhada, String prioridade, Date dataInicio, Date dataConclusao, int trabalhoEstimado, int trabalhoReal) {
        this.assunto = assunto;
        this.descricaoDetalhada = descricaoDetalhada;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.trabalhoEstimado = trabalhoEstimado;
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
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

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
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
}

