package projetofinal;

import java.util.Scanner;

public class TarefaSuporte extends Tarefa {

    private int tempoMaximo;  
    private boolean urgente;  

    public TarefaSuporte(int codigo, Tecnico responsavel, int tempoMaximo, boolean urgente) {
        super(codigo, responsavel);
        this.tempoMaximo = tempoMaximo;
        this.urgente = urgente;
    }

    public static int validarTempoMaximo(Scanner sc) {
        int tempo;
        do {
            System.out.print("Tempo máximo (dias) para realização do suporte (valor positivo): ");
            tempo = sc.nextInt();
            sc.nextLine();
        } while (tempo <= 0);
        return tempo;
    }

    public static boolean validarUrgente(Scanner sc) {
        String opcao;
        do {
            System.out.print("A tarefa é urgente? (S/N): ");
            opcao = sc.nextLine().trim().toUpperCase();
        } while (!opcao.equals("S") && !opcao.equals("N"));

        return opcao.equals("S");
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tempo Máximo (dias): " + tempoMaximo);
        System.out.println("Urgente: " + (urgente ? "Sim" : "Não"));
        System.out.println("Tipo: Suporte");
    }
}