package ao.universidade.poo.biblioteca;

import java.time.LocalDate;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel = true;

    private LocalDate dataEmprestimo;

    public Livro(String titulo, String autor, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título inválido");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor inválido");
        }
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            throw new IllegalArgumentException("ISBN deve ter 13 caracteres");
        }
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public boolean emprestar() {

        if (!disponivel) {
            return false;
        }

        disponivel = false;
        dataEmprestimo = LocalDate.now();

        return true;
    }

    public void devolver() {
        disponivel = true;
        dataEmprestimo = null;
    }

    public boolean estaAtrasado() {

        if (dataEmprestimo == null) {
            return false;
        }

        return dataEmprestimo.plusDays(7).isBefore(LocalDate.now());
    }

    public String info() {

        return String.format(
                "%s - %s | ISBN: %s | Disponível: %s",
                titulo,
                autor,
                isbn,
                disponivel ? "Sim" : "Não"
        );
    }

    @Override
    public String toString() {
        return info();
    }
}