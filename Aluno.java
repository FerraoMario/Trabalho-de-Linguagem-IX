package ao.universidade.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private String numeroMatricula;
    private String curso;

    private List<Livro> emprestimos = new ArrayList<>();

    private final int LIMITE_LIVROS = 3;

    public Aluno(String nome, String numeroMatricula, String curso) {

        setNome(nome);
        setNumeroMatricula(numeroMatricula);
        setCurso(curso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {

        if (numeroMatricula == null || numeroMatricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula inválida");
        }

        this.numeroMatricula = numeroMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {

        if (curso == null) {
            curso = "";
        }

        this.curso = curso;
    }

    public boolean matricularLivro(Livro livro) {

        if (livro == null) {
            throw new IllegalArgumentException("Livro nulo");
        }

        if (emprestimos.size() >= LIMITE_LIVROS) {

            System.out.println("Limite de empréstimos atingido!");
            return false;
        }

        if (!livro.emprestar()) {
            return false;
        }

        emprestimos.add(livro);

        return true;
    }

    public boolean devolverLivro(Livro livro) {

        if (livro == null) {
            throw new IllegalArgumentException("Livro nulo");
        }

        boolean removido = emprestimos.remove(livro);

        if (removido) {
            livro.devolver();
        }

        return removido;
    }

    public void mostrarEmprestimos() {

        if (emprestimos.isEmpty()) {

            System.out.println(nome + " não possui livros.");
            return;
        }

        System.out.println("\nLivros de " + nome + ":");

        for (Livro livro : emprestimos) {

            System.out.println(livro.info());

            if (livro.estaAtrasado()) {
                System.out.println("⚠ Livro atrasado!");
            }
        }
    }
}