import entities.*;
import storage.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();

        // Create TipoDoacao
        TipoDoacao dinheiro = new TipoDoacao("Dinheiro", "Doação em espécie");
        TipoDoacao material = new TipoDoacao("Material", "Doação de material odontológico");

        repo.addTipoDoacao(dinheiro);
        repo.addTipoDoacao(material);

        // Create Doador and donations
        Doador joao = new Doador("João Silva", "joao@example.com", "99999-0000", "Rua A, 123", LocalDate.now());
        repo.addPessoa(joao);

        Doacao d1 = new Doacao(dinheiro, 200.0, LocalDate.now());
        Doacao d2 = new Doacao(material, 0.0, LocalDate.now());
        joao.addDoacao(d1);
        joao.addDoacao(d2);

        // Create Programa Social and Criterio
        ProgramaSocial ps = new ProgramaSocial("Sorriso Solidário", "Atende famílias de baixa renda", 0, 99);
        CriterioSelecao criterio = new CriterioSelecao("Renda", "Renda familiar abaixo do limite");

        repo.addProgramaSocial(ps);
        repo.addCriterio(criterio);

        // Create Beneficiario
        Beneficiario maria = new Beneficiario("Maria Oliveira", "maria@example.com", "98888-1111", "Rua B, 456",
                LocalDate.of(1990, 5, 10), ps, criterio);
        repo.addPessoa(maria);

        // Create Dentista
        EspecialidadeDentista esp = new EspecialidadeDentista("Ortodontia", "ORT");
        Dentista drPaulo = new Dentista("Paulo Costa", "paulo@clinic.com", "97777-2222", "Av Saúde, 10",
                LocalDate.now(), esp, StatusDentista.ATIVO);
        repo.addPessoa(drPaulo);

        // Create Atendimento
        Atendimento atendimento = new Atendimento(maria, drPaulo, LocalDateTime.now(), StatusAtendimento.ABERT0, Prioridade.MEDIA, "Avaliação inicial");
        repo.addAtendimento(atendimento);

        // Print summary
        System.out.println("=== Pessoas cadastradas ===");
        for (Pessoa p : repo.getPessoas()) {
            System.out.println(p);
        }

        System.out.println("\n=== Doações de João ===");
        for (Doacao dd : joao.getDoacoes()) {
            System.out.println(dd);
        }

        System.out.println("\n=== Atendimentos ===");
        for (Atendimento a : repo.getAtendimentos()) {
            System.out.println(a);
        }
    }
}
