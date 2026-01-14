package projetofinal;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== MENU DE TAREFAS ===");
            System.out.println("1 - Incluir Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Remover Tarefa");
            System.out.println("4 - Sair");
            System.out.print("Escolha a opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:  // INCLUIR TAREFA
                    System.out.println("\n--- INCLUIR TAREFA ---");

                    int codigo;
                    boolean codigoRepetido;
                    do {
                        System.out.print("Digite o código da tarefa: ");
                        codigo = sc.nextInt();
                        sc.nextLine();

                        codigoRepetido = false;
                        for (Tarefa t : tarefas) {
                            if (t.getCodigo() == codigo) {
                                System.out.println("Já existe uma tarefa com esse código! Digite outro.");
                                codigoRepetido = true;
                                break;
                            }
                        }
                    } while (codigoRepetido);

                    System.out.print("Nome do Técnico: ");
                    String nome = sc.nextLine();

                    System.out.print("Especialidade do Técnico: ");
                    String esp = sc.nextLine();

                    Tecnico tecnico = new Tecnico(nome, esp);

                    int tipoTarefa;
                    do {
                        System.out.print("Informe o tipo de tarefa: \n1 - Tarefa de suporte \n2 - Tarefa de desenvolvimento ");
                        tipoTarefa = sc.nextInt();
                        sc.nextLine();
                    } while (tipoTarefa != 1 && tipoTarefa != 2);

                    if (tipoTarefa == 1) {
                        int tempo = TarefaSuporte.validarTempoMaximo(sc);
                        boolean urgente = TarefaSuporte.validarUrgente(sc);
                        tarefas.add(new TarefaSuporte(codigo, tecnico, tempo, urgente));
                    } else {
                        System.out.print("Tipo de linguagem de programção: ");
                        String linguagem = sc.nextLine();
                        char tipo = TarefaDev.validarTipo(sc);
                        tarefas.add(new TarefaDev(codigo, tecnico, linguagem, tipo));
                    }

                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:  // LISTAR
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (Tarefa t : tarefas) {
                            System.out.println("\n-------------------------");
                            t.exibirDados();
                        }
                    }
                    break;

                case 3:  // REMOVER
                    System.out.println("\n--- REMOVER TAREFA ---");

                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa para remover.");
                        break;
                    }

                    System.out.println("Tarefas cadastradas:");
                    for (Tarefa t : tarefas) {
                        System.out.println("Código: " + t.getCodigo());
                    }

                    System.out.print("Digite o código a remover: ");
                    int codRemover = sc.nextInt();
                    sc.nextLine();

                    boolean removida = tarefas.removeIf(t -> t.getCodigo() == codRemover);

                    if (removida) {
                        System.out.println("Tarefa removida.");
                    } else {
                        System.out.println("Código não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Total de tarefas cadastradas: " + tarefas.size());
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }
}