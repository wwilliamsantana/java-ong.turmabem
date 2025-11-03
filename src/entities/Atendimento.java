package entities;

import java.time.LocalDateTime;

public class Atendimento {
    private Beneficiario solicitante;
    private Dentista dentista;
    private LocalDateTime dataHora;
    private StatusAtendimento status;
    private Prioridade prioridade;
    private String descricao;

    public Atendimento(Beneficiario solicitante, Dentista dentista, LocalDateTime dataHora, StatusAtendimento status, Prioridade prioridade, String descricao) {
        this.solicitante = solicitante;
        this.dentista = dentista;
        this.dataHora = dataHora;
        this.status = status;
        this.prioridade = prioridade;
        this.descricao = descricao;
    }

    public Beneficiario getSolicitante() { return solicitante; }
    public Dentista getDentista() { return dentista; }
    public LocalDateTime getDataHora() { return dataHora; }
    public StatusAtendimento getStatus() { return status; }
    public Prioridade getPrioridade() { return prioridade; }

    @Override
    public String toString() {
        return String.format("Atendimento{solicitante=%s, dentista=%s, dataHora=%s, status=%s}", solicitante.getNome(), dentista.getNome(), dataHora, status);
    }
}
