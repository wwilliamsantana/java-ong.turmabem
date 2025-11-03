package entities;

public class ProgramaSocial {
    private String nome;
    private String descricao;
    private int idadeMinima;
    private int idadeMaxima;

    public ProgramaSocial(String nome, String descricao, int idadeMinima, int idadeMaxima) {
        this.nome = nome;
        this.descricao = descricao;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return String.format("ProgramaSocial{nome='%s'}", nome);
    }
}
