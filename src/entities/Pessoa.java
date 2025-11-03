package entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Pessoa {
    private static final AtomicLong SEQ = new AtomicLong(1);
    private final long id;
    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private LocalDate dataCadastro;

    public Pessoa(String nome, String email, String telefone, String logradouro, LocalDate dataCadastro) {
        this.id = SEQ.getAndIncrement();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.dataCadastro = dataCadastro;
    }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getLogradouro() { return logradouro; }
    public LocalDate getDataCadastro() { return dataCadastro; }

    @Override
    public String toString() {
        return String.format("Pessoa{id=%d, nome='%s', email='%s'}", id, nome, email);
    }
}
