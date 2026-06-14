import java.util.List;

public class UI {

    public static void exibirComentario(Comentario comentario, String caminho);

    public static void exibirMenu();

    public static void exibirMenuInicial();

    public static void exibirFolhas(List<Comentario> folha);

    public static void exibirArvore(String arvoreTexto);

    public static void limparTela();

}

/*
*
* Responsabilidades
exibirComentario(...)

Deve mostrar:

ID: 4
Autor: João

Texto:
Gostei da proposta.

Respostas: 3

Caminho:
DISCUSSÃO > 1 > 3 > 4

Além disso, listar os comentários filhos diretos para facilitar a navegação.

exibirMenu()

Mostra todos os comandos disponíveis.

exibirMenuInicial()

Mostra:

breve explicação do sistema;
menu de comandos.

Pode chamar exibirMenu() internamente para evitar repetição.

exibirFolhas(...)

Mostra todos os comentários que não possuem respostas.

exibirArvore(...)

Mostra a árvore completa de comentários.

limparTela()

Limpa a tela entre as navegações.
* */
