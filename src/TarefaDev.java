package projetofinal;

import java.util.Scanner;

public class TarefaDev extends Tarefa {

    private String linguagem;
    private char tipo;  

    public TarefaDev(int codigo, Tecnico responsavel, String linguagem, char tipo) {
        super(codigo, responsavel);
        this.linguagem = linguagem;
        this.tipo = tipo;
    }

    public static char validarTipo(Scanner sc) {
        String valor;
        do {
            System.out.print("Tipo da tarefa (N = Nova, C = Correção): ");
            valor = sc.nextLine().trim().toUpperCase();
        } while (!valor.equals("N") && !valor.equals("C"));

        return valor.charAt(0);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Linguagem: " + linguagem);
        System.out.println("Tipo (N/C): " + tipo);
        System.out.println("Tipo: Desenvolvimento");
    }
}
