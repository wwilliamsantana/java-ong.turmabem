package services;

import entities.*;
import storage.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuServices {

    private final Scanner scanner;
    private final Repository repo;


    public MenuServices(Scanner scanner, Repository repo) {
        this.scanner = scanner;
        this.repo = repo;
    }

    public void cadastrarDoador() {
        System.out.println("-> Cadastro de Doador");
        System.out.print("Nome: ");
        String nomeDoador = scanner.nextLine();
        System.out.print("Email: ");
        String emailDoador = scanner.nextLine();
        System.out.print("Telefone: ");
        String telDoador = scanner.nextLine();
        System.out.print("Endereço: ");
        String endDoador = scanner.nextLine();

        Doador novoDoador = new Doador(nomeDoador, emailDoador, telDoador, endDoador, LocalDate.now());
        repo.addPessoa(novoDoador);
        System.out.println("Doador cadastrado com sucesso!");
    }

    public void cadastrarBeneficiario(ProgramaSocial ps, CriterioSelecao criterio ){

        System.out.println("-> Cadastro de Beneficiário");
        System.out.print("Nome: ");
        String nomeBenef = scanner.nextLine();
        System.out.print("Email: ");
        String emailBenef = scanner.nextLine();
        System.out.print("Telefone: ");
        String telBenef = scanner.nextLine();
        System.out.print("Endereço: ");
        String endBenef = scanner.nextLine();

        Beneficiario novoBenef = new Beneficiario(nomeBenef, emailBenef, telBenef, endBenef,
                LocalDate.of(1990, 5, 10), ps, criterio); // Data fictícia
        repo.addPessoa(novoBenef);
        System.out.println("Beneficiário cadastrado com sucesso!");
    }

    public void cadastrarDentista(EspecialidadeDentista especialidadeDent){
        System.out.println("-> Cadastro de Dentista");
        System.out.print("Nome: ");
        String nomeDent = scanner.nextLine();
        System.out.print("Email: ");
        String emailDent = scanner.nextLine();
        System.out.print("Telefone: ");
        String telDent = scanner.nextLine();
        System.out.print("Endereço: ");
        String endDent = scanner.nextLine();


        Dentista novoDentista = new Dentista(nomeDent, emailDent, telDent, endDent,
                LocalDate.now(), especialidadeDent, StatusDentista.ATIVO);
        repo.addPessoa(novoDentista);
        System.out.println("Dentista cadastrado com sucesso!");
    }

    public void agendamentoAtendimento( Beneficiario bSelecionado, List<Dentista> dentistas,  int dentIndex){
        Dentista dSelecionado = dentistas.get(dentIndex);
        scanner.nextLine();


        System.out.print("Descrição/Observação do atendimento: ");
        String obs = scanner.nextLine();


        System.out.println("Selecione a Prioridade: [1] ALTA [2] MEDIA [3] BAIXA");
        System.out.print("Opção: ");
        int priorOp = scanner.nextInt();
        Prioridade pSelecionada = Prioridade.MEDIA;
        if (priorOp == 1) pSelecionada = Prioridade.ALTA;
        else if (priorOp == 3) pSelecionada = Prioridade.BAIXA;
        scanner.nextLine();


        Atendimento novoAtendimento = new Atendimento(
                bSelecionado,
                dSelecionado,
                LocalDateTime.now(),
                StatusAtendimento.ABERT0,
                pSelecionada,
                obs
        );

        repo.addAtendimento(novoAtendimento);
        System.out.println("\n+++ Atendimento agendado com sucesso! +++");
        System.out.println(novoAtendimento);
    }

    public void getPessoasCadastradas(){
        System.out.println("\n=== Pessoas cadastradas ===");
        if (repo.getPessoas().isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa p : repo.getPessoas()) {
                System.out.println(p);
            }
        }
    }

    public void getProgramasSociais(){
        System.out.println("\n=== Programas Sociais ===");
        for (ProgramaSocial p : repo.getProgramas()) {
            System.out.println(p);
        }
    }

    public void getDoacoes(){
        System.out.println("\n=== Tipos de Doação ===");
        for (TipoDoacao t : repo.getTiposDoacao()) {
            System.out.println(t);
        }
    }

    public void getAtendimento(){
        System.out.println("\n=== Atendimentos Agendados ===");
        if (repo.getAtendimentos().isEmpty()) {
            System.out.println("Nenhum atendimento agendado.");
        } else {
            for (Atendimento a : repo.getAtendimentos()) {
                System.out.println(a);
            }
        }
    }
}