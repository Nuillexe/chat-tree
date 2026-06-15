import java.util.LinkedList;
import java.util.List;

class ComentarioTree {

    private Comentario raiz;

    public ComentarioTree(){
        raiz = new Comentario("", "DISCUSSÃO", null);
    }

    public Comentario getRaiz();

    public Comentario adicionarComentario(String autor, String texto, Comentario pai) {
        Comentario novoComentario = new Comentario(autor, texto, pai);
        if(pai != null) {
            pai.getRespostas().add(novoComentario);
        }
        return novoComentario;
    }


    public void removerComentario(Comentario comentario){
        if(comentario == null || comentario ==raiz){
            return;
        }
        Comentario pai = comentario.getPai();

        if(pai !=null){
            pai.getRespostas().remove(comentario);
        }
    }

    public Comentario buscarPorId(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Comentario buscarRecursivo(Comentario atual,int id) {
        if(atual == null) {
            return null;
        }

        if(atual.getId() == id) {
            return atual;
        }

        for(Comentario filho : atual.getRespostas()){
            Comentario encontrado = buscarRecursivo(filho, id);

            if(encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
    public String obterCaminho(Comentario comentario){
        if(comentario.getPai()==null){
            return "DUSCUSSÃO";
        }
        return obterCaminho(comentario.getPai())
                + " > "
                + comentario.getId();
        }
    }

    public List<Comentario> listarFolhas();

    public int contarComentarios();

    public String gerarArvoreTexto();

    public LinkedList<Comentario> comentariosDoAutor(String nomeDoAutor){


    }
}

/*
* Responsabilidades
adicionarComentario(...)

Cria um novo comentário e o adiciona como filho do comentário informado.

removerComentario(...)

Remove um comentário e toda sua subárvore de respostas.

Exemplo:

DISCUSSÃO
└── 1
    └── 2
        └── 3

Removendo o comentário 2:

DISCUSSÃO
└── 1
buscarPorId(...)

Busca recursivamente um comentário pelo ID.

Retorna:

o comentário encontrado;
null caso não exista.
obterCaminho(...)

Função recursiva.

Retorna o caminho desde a raiz até o comentário.

Exemplo:

DISCUSSÃO > 1 > 3 > 4
listarFolhas()

Retorna todos os comentários que não possuem respostas.

contarComentarios()

Retorna a quantidade total de comentários da árvore.

gerarArvoreTexto()

Percorre a árvore em pré-ordem e gera uma representação textual.

Exemplo:

DISCUSSÃO
├── 1
│   ├── 2
│   └── 3
└── 4
* */
