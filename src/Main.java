import entities.*;
import services.MenuServices;
import storage.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();
        Scanner scanner = new Scanner(System.in);
        MenuServices  menuServices = new MenuServices(scanner, repo);


        TipoDoacao dinheiro = new TipoDoacao("Dinheiro", "Doação em espécie");
        repo.addTipoDoacao(dinheiro);
        ProgramaSocial progSocial = new ProgramaSocial("Sorriso Solidário", "Atende famílias de baixa renda", 0, 99);
        repo.addProgramaSocial(progSocial);
        CriterioSelecao criterio = new CriterioSelecao("Renda", "Renda familiar abaixo do limite");
        repo.addCriterio(criterio);
        EspecialidadeDentista especialidadeDent = new EspecialidadeDentista("Ortodontia", "ORT");

        Beneficiario maria = new Beneficiario("Maria Oliveira", "maria@example.com", "98888-1111", "Rua B, 456",
                LocalDate.of(1990, 5, 10), progSocial, criterio);
        repo.addPessoa(maria);
        Dentista drPaulo = new Dentista("Paulo Costa", "paulo@clinic.com", "97777-2222", "Av Saúde, 10",
                LocalDate.now(), especialidadeDent, StatusDentista.ATIVO);
        repo.addPessoa(drPaulo);

        boolean executando = true;
        while (executando) {

            System.out.println("\n--- MENU DE GERENCIAMENTO ---");
            System.out.println("CADASTROS:");
            System.out.println("[1] Cadastrar Doador");
            System.out.println("[2] Cadastrar Beneficiário");
            System.out.println("[3] Cadastrar Dentista");
            System.out.println("\nAÇÕES:");
            System.out.println("[4] Agendar Atendimento");
            System.out.println("\nLISTAGEM:");
            System.out.println("[5] Listar Pessoas (Todos)");
            System.out.println("[6] Listar Programas Sociais");
            System.out.println("[7] Listar Tipos de Doação");
            System.out.println("[8] Listar Atendimentos");
            System.out.println("-----------------------------");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuServices.cadastrarDoador();
                    break;
                case 2:
                    menuServices.cadastrarBeneficiario(progSocial, criterio);
                    break;
                case 3:
                    menuServices.cadastrarDentista(especialidadeDent);
                    break;
                case 4:
                    System.out.println("-> Agendamento de Atendimento");

                    List<Beneficiario> beneficiarios = repo.getBeneficiarios();
                    if (beneficiarios.isEmpty()) {
                        System.out.println("ERRO: Nenhum beneficiário cadastrado. Cadastre um primeiro.");
                        break;
                    }

                    System.out.println("Selecione o Beneficiário:");
                    for (int i = 0; i < beneficiarios.size(); i++) {
                        System.out.printf("[%d] %s\n", (i + 1), beneficiarios.get(i).getNome());
                    }
                    System.out.print("Opção: ");
                    int benefIndex = scanner.nextInt() - 1;


                    if (benefIndex < 0 || benefIndex >= beneficiarios.size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }
                    Beneficiario bSelecionado = beneficiarios.get(benefIndex);

                    List<Dentista> dentistas = repo.getDentistas();
                    if (dentistas.isEmpty()) {
                        System.out.println("ERRO: Nenhum dentista cadastrado. Cadastre um primeiro.");
                        break;
                    }

                    System.out.println("Selecione o Dentista:");
                    for (int i = 0; i < dentistas.size(); i++) {
                        System.out.printf("[%d] %s (Espec: %s)\n", (i + 1), dentistas.get(i).getNome(), dentistas.get(i).getEspecialidade().getNome());
                    }
                    System.out.print("Opção: ");
                    int dentIndex = scanner.nextInt() - 1;

                    if (dentIndex < 0 || dentIndex >= dentistas.size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    menuServices.agendamentoAtendimento(bSelecionado, dentistas, dentIndex);
                    break;

                case 5:
                    menuServices.getPessoasCadastradas();
                    break;
                case 6:
                    menuServices.getProgramasSociais();
                    break;
                case 7:
                    menuServices.getDoacoes();
                    break;
                case 8:
                    menuServices.getAtendimento();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Pressione Enter para tentar novamente.");
                    scanner.nextLine();
            }
        }


        scanner.close();
    }
}