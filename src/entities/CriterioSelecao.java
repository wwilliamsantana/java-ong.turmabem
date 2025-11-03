package entities;

public class CriterioSelecao {
    private String nome;
    private String descricao;

    public CriterioSelecao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return String.format("CriterioSelecao{nome='%s'}", nome);
    }
}
