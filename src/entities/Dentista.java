package entities;

import java.time.LocalDate;

public class Dentista extends Pessoa {
    private EspecialidadeDentista especialidade;
    private StatusDentista status;

    public Dentista(String nome, String email, String telefone, String logradouro, LocalDate dataCadastro,
                    EspecialidadeDentista especialidade, StatusDentista status) {
        super(nome, email, telefone, logradouro, dataCadastro);
        this.especialidade = especialidade;
        this.status = status;
    }

    public EspecialidadeDentista getEspecialidade() { return especialidade; }
    public StatusDentista getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Dentista{id=%d, nome='%s', especialidade='%s'}", getId(), getNome(), especialidade.getNome());
    }
}
