import java.util.LinkedList;

public class Comentario {

    private static int proximoId = 1;

    private int id;
    private String autor;
    private String texto;
    private Comentario pai;
    private LinkedList<Comentario> respostas;

    public Comentario(Comentario pai) {
        this.pai = pai;
    }

    public Comentario(String autor, String texto, Comentario pai){
        this.autor = autor;
        this.texto = texto;
        this.pai = pai;
        this.respostas = new LinkedList<>();
        this.id = proximoId++;
    }

    public void setId(int id) { this.id = id; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setTexto(String texto) { this.texto = texto; }

    public int getId() { return id; }
    public String getAutor() { return autor; }
    public String getTexto() { return texto; }
    public Comentario getPai() { return pai; }

    // Métodos adicionados para que a classe UI consiga ler as respostas:
    public LinkedList<Comentario> getRespostas() {
        return respostas;
    }

    public int getQuantidadeRespostas() {
        return respostas != null ? respostas.size() : 0;
    }
}
