import java.util.Scanner;

public class ForumService {

    private ComentarioTree tree;

    public ForumService(ComentarioTree tree){
        this.tree = tree;}

    public void criarComentario(Comentario comentarioPai);

    public void editarComentario(Comentario comentario);

    public Comentario voltarParaPai(Comentario atual);

    public Comentario deletarComentarioAtual(Comentario atual);

    public String lerComando(Scanner sc);

    public int lerId(Scanner sc);



}

/*
* Responsabilidades
criarComentario(...)

Solicita ao usuário:

autor
texto

e cria o comentário como filho do comentário informado.

editarComentario(...)

Permite alterar o texto do comentário.

voltarParaPai(...)

Retorna o pai do comentário atual.

Caso o comentário atual seja a raiz, retorna a própria raiz.

deletarComentarioAtual(...)

Remove o comentário atual da árvore.

Após a remoção, retorna o comentário pai para que a navegação continue válida.

lerComando(...)

Lê um comando digitado pelo usuário.

Comandos válidos:

C - Criar comentário
D - Deletar comentário
E - Editar comentário
V - Visitar comentário filho
B - Voltar ao pai
F - Mostrar folhas
A - Mostrar árvore completa
M - Mostrar menu

Caso o comando seja inválido:

exibir mensagem de erro;
solicitar novamente.
lerId(...)

Lê e valida um ID informado pelo usuário.


* */
