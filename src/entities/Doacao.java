package entities;

import java.time.LocalDate;

public class Doacao {
    private TipoDoacao tipo;
    private double valor;
    private LocalDate data;

    public Doacao(TipoDoacao tipo, double valor, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public TipoDoacao getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return String.format("Doacao{tipo=%s, valor=%.2f, data=%s}", tipo.getNome(), valor, data);
    }
}
