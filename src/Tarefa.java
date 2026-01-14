package projetofinal;

public class Tarefa {
    private int codigo;
    private Tecnico responsavel;

    public Tarefa(int codigo, Tecnico responsavel) {
        this.codigo = codigo;
        this.responsavel = responsavel;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tecnico getResponsavel() {
        return responsavel;
    }

    public void exibirDados() {
        System.out.println("Código da Tarefa: " + codigo);
        System.out.println("Técnico Responsável: " + responsavel.getNome());
        System.out.println("Especialidade do Técnico: " + responsavel.getEspecialidade());
    }
}