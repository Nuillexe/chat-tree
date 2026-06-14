import java.util.LinkedList;

public class Comentario {

    private static int proximoId = 1;

    private int id;
    private String autor;
    private String texto;

    private Comentario pai;

    private LinkedList<Comentario> respostas;

    public Comentario(
            String autor,
            String texto,
            Comentario pai
    ){
        this.autor = autor;
        this.texto = texto;
        this.pai = pai;

        this.respostas = new LinkedList<>();

        this.id = proximoId++;
    }

    // getters e setters
}
