import java.util.List;

class ComentarioTree {

    private Comentario raiz;

    public ComentarioTree(){
        raiz = new Comentario("", "DISCUSSÃO", null);
    }

    public Comentario getRaiz();

    public Comentario adicionarComentario(String autor, String texto, Comentario pai);

    public void removerComentario(Comentario comentario);

    public Comentario buscarPorId(int id);

    public String obterCaminho(Comentario comentario);

    public List<Comentario> listarFolhas();

    public int contarComentarios();

    public String gerarArvoreTexto();

   //adicionado por kaique

    public int contarComentarios();

    private int contarContagemRecursiva(Comentario atual);

    public int contarComentariosPorAutor(String autor);

    private int contarPorAutorRecursivo(Comentario atual, String autor);

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