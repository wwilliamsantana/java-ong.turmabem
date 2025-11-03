package entities;

public class TipoDoacao {
    private String nome;
    private String descricao;

    public TipoDoacao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return String.format("TipoDoacao{nome='%s'}", nome);
    }
}
