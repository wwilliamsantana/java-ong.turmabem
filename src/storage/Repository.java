package storage;

import entities.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final List<Pessoa> pessoas = new ArrayList<>();
    private final List<Atendimento> atendimentos = new ArrayList<>();
    private final List<TipoDoacao> tiposDoacao = new ArrayList<>();
    private final List<ProgramaSocial> programas = new ArrayList<>();
    private final List<CriterioSelecao> criterios = new ArrayList<>();

    public void addPessoa(Pessoa p) { pessoas.add(p); }
    public List<Pessoa> getPessoas() { return pessoas; }

    public void addAtendimento(Atendimento a) { atendimentos.add(a); }
    public List<Atendimento> getAtendimentos() { return atendimentos; }

    public void addTipoDoacao(TipoDoacao t) { tiposDoacao.add(t); }
    public List<TipoDoacao> getTiposDoacao() { return tiposDoacao; }

    public void addProgramaSocial(ProgramaSocial p) { programas.add(p); }
    public List<ProgramaSocial> getProgramas() { return programas; }

    public void addCriterio(CriterioSelecao c) { criterios.add(c); }
    public List<CriterioSelecao> getCriterios() { return criterios; }

    public List<Beneficiario> getBeneficiarios() {
        List<Beneficiario> listaFiltrada = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Beneficiario) {
                listaFiltrada.add((Beneficiario) p); // Converte (cast) Pessoa para Beneficiario
            }
        }
        return listaFiltrada;
    }
    public List<Dentista> getDentistas() {
        List<Dentista> listaFiltrada = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Dentista) {
                listaFiltrada.add((Dentista) p); // Converte (cast) Pessoa para Dentista
            }
        }
        return listaFiltrada;
    }
}
