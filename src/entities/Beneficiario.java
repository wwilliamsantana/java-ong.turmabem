package entities;

import java.time.LocalDate;

public class Beneficiario extends Pessoa {
    private LocalDate dataNascimento;
    private ProgramaSocial programaSocial;
    private CriterioSelecao criterioSelecao;

    public Beneficiario(String nome, String email, String telefone, String logradouro, LocalDate dataNascimento,
                        ProgramaSocial programaSocial, CriterioSelecao criterioSelecao) {
        super(nome, email, telefone, logradouro, LocalDate.now());
        this.dataNascimento = dataNascimento;
        this.programaSocial = programaSocial;
        this.criterioSelecao = criterioSelecao;
    }

    public ProgramaSocial getProgramaSocial() { return programaSocial;}
    public CriterioSelecao getCriterioSelecao() { return criterioSelecao; }

    @Override
    public String toString() {
        return String.format("Beneficiario{id=%d, nome='%s', programa='%s'}", getId(), getNome(), programaSocial.getNome());
    }
}
