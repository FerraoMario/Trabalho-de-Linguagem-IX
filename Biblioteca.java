package ao.universidade.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> catalogo = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        catalogo.add(livro);
    }

    public void listarLivros() {

        System.out.println("\n=== CATÁLOGO ===");

        for (Livro livro : catalogo) {
            System.out.println(livro.info());
        }
    }

    public Livro buscarPorTitulo(String titulo) {

        for (Livro livro : catalogo) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public void listarDisponiveis() {

        System.out.println("\n=== LIVROS DISPONÍVEIS ===");

        for (Livro livro : catalogo) {

            if (livro.isDisponivel()) {
                System.out.println(livro.info());
            }
        }
    }
}