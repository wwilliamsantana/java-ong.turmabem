package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doador extends Pessoa {
    private final List<Doacao> doacoes = new ArrayList<>();

    public Doador(String nome, String email, String telefone, String logradouro, LocalDate dataCadastro) {
        super(nome, email, telefone, logradouro, dataCadastro);
    }

    public void addDoacao(Doacao d) { doacoes.add(d); }
    public List<Doacao> getDoacoes() { return doacoes; }

    @Override
    public String toString() {
        return String.format("Doador{id=%d, nome='%s', totalDoacoes=%d}", getId(), getNome(), doacoes.size());
    }
}
