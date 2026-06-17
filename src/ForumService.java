import java.util.Scanner;

/**
 * Camada de serviço do fórum.
 *
 * Responsável por intermediar as operações entre a interface
 * da aplicação e a estrutura de dados ComentarioTree.
 */
public class ForumService {

    private final ComentarioTree tree;
    private final Scanner sc;

    /**
     * Cria um serviço associado à árvore de comentários.
     *
     * @param tree árvore de comentários
     * @param sc scanner compartilhado pela aplicação
     */
    public ForumService(ComentarioTree tree, Scanner sc) {
        this.tree = tree;
        this.sc = sc;
    }

    /**
     * Solicita autor e texto ao usuário e cria um novo comentário
     * como filho do comentário informado.
     *
     * @param comentarioPai comentário pai
     */
    public void criarComentario(Comentario comentarioPai) {

        System.out.print("Autor: ");
        String autor = sc.nextLine().trim();

        System.out.print("Texto: ");
        String texto = sc.nextLine().trim();

        if (autor.isEmpty() || texto.isEmpty()) {
            System.out.println("Autor e texto não podem ser vazios.");
            return;
        }

        tree.adicionarComentario(
                autor,
                texto,
                comentarioPai
        );

        System.out.println("Comentário criado com sucesso.");
    }

    /**
     * Permite alterar o texto de um comentário existente.
     *
     * A raiz da discussão não pode ser editada.
     *
     * @param comentario comentário a ser editado
     */
    public void editarComentario(Comentario comentario) {

        if (comentario.getPai() == null) {
            System.out.println("Não é possível editar a raiz da discussão.");
            return;
        }

        System.out.print("Novo texto: ");
        String novoTexto = sc.nextLine().trim();

        if (novoTexto.isEmpty()) {
            System.out.println("O texto não pode ser vazio.");
            return;
        }

        comentario.setTexto(novoTexto);

        System.out.println("Comentário atualizado.");
    }

    /**
     * Retorna o comentário pai do comentário atual.
     * Caso o comentário atual seja a raiz,
     * retorna o próprio comentário.
     *
     * @param atual comentário atual
     * @return comentário pai ou a própria raiz
     */
    public Comentario voltarParaPai(Comentario atual) {

        if (atual.getPai() == null) {
            return atual;
        }

        return atual.getPai();
    }

    /**
     * Remove o comentário atual da árvore.
     * Após a remoção, retorna o comentário pai para que
     * a navegação continue válida.
     *
     * A raiz da discussão não pode ser removida.
     *
     * @param atual comentário a ser removido
     * @return comentário pai após a remoção
     */
    public Comentario deletarComentarioAtual(Comentario atual) {

        if (atual.getPai() == null) {
            System.out.println("Não é possível remover a raiz da discussão.");
            return atual;
        }

        Comentario pai = atual.getPai();

        tree.removerComentario(atual);

        System.out.println("Comentário removido.");

        return pai;
    }

    /**
     * Lê um comando do usuário e garante que ele seja válido.
     *
     * Comandos válidos:
     * C  - Criar comentário
     * D  - Deletar comentário
     * E  - Editar comentário
     * V  - Visitar comentário filho
     * B  - Voltar ao pai
     * F  - Mostrar folhas
     * A  - Mostrar árvore completa
     * M  - Mostrar menu
     * U  - Atualizar interface
     * B0 - Voltar para a raiz
     *
     * @param sc scanner utilizado para leitura
     * @return comando validado
     */
    public String lerComando(Scanner sc) {

        while (true) {
            System.out.println("Digite M caso precise rever o menu de comandos");
            System.out.print("Comando: ");
            String cmd = sc.nextLine().trim().toUpperCase();

            switch (cmd) {
                case "C":
                case "D":
                case "E":
                case "V":
                case "B":
                case "F":
                case "A":
                case "M":
                case "U":
                case "B0":
                case "S":
                    return cmd;

                default:
                    System.out.println("Comando inválido.");
            }
        }
    }

    /**
     * Lê e valida um ID informado pelo usuário.
     *
     * @param sc scanner utilizado para leitura
     * @return ID válido
     */
    public int lerId(Scanner sc) {

        while (true) {

            try {
                System.out.print("Digite o ID: ");
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Digite um número inteiro.");
            }
        }
    }

    /**
     * Pausa a execução até que o usuário pressione ENTER.
     *
     * @param sc scanner utilizado para leitura
     */
    public void pressionarEnterParaContinuar(Scanner sc) {

        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
