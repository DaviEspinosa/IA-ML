public class Filmes {
    String titulo;
    int ano;
    String genero;
    double nota;
    Filmes esquerda;
    Filmes direita;


    Filmes(String titulo, int ano, String genero, double nota) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;
        this.esquerda = null;
        this.direita = null;
    }
}
