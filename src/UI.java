import java.util.List;

public class UI {

    public static void exibirComentario(Comentario comentario, String caminho){
        System.out.println("=============================================================");
        System.out.printf("ID: %d%n", comentario.getId());
        System.out.printf("Autor: %s%n", comentario.getAutor());
        System.out.printf("%nTexto:%n%s%n%n", comentario.getTexto());
        System.out.printf("Respostas: %d%n", comentario.getQuantidadeRespostas());
        System.out.printf("%nCaminho:%n%s%n", caminho);
        System.out.println("=============================================================");

        // Comentários filhos diretos
        if (comentario.getQuantidadeRespostas() > 0) {
            System.out.println("Respostas diretas (Filhos):");
            for (Comentario filho : comentario.getRespostas()) {
                System.out.printf("  -> [ID: %d] %s: \"%s\"%n",
                        filho.getId(), filho.getAutor(),
                        filho.getTexto().length() > 30 ? filho.getTexto().substring(0, 30) + "..." : filho.getTexto());
            }
            System.out.println("=============================================================");
        }
    }

    public static void exibirMenu(){
        System.out.println("=============================================================");
        System.out.println("Menu de Comandos");
        System.out.println("=============================================================");
        System.out.println("C - Criar comentário");
        System.out.println("D - Deletar comentário");
        System.out.println("E - Editar comentário");
        System.out.println("V - Visitar comentário filho");
        System.out.println("B - Voltar ao comentário pai");
        System.out.println("F - Mostrar folhas");
        System.out.println("A - Mostrar árvore completa");
        System.out.println("T - Mostrar quantidade total de comentários");
        System.out.println("U - Mostrar total de comentários de um usuário");

        System.out.println("M - Mostrar menu");
        System.out.println("=============================================================");
    }

    public static void exibirMenuInicial(){
        System.out.println("=============================================================");
        System.out.println("    SISTEMA DE FÓRUM EM ÁRVORE (DISCUSSÃO ENCADEADA)         ");
        System.out.println("=============================================================");
        System.out.println("Bem-vindo! Este sistema permite organizar discussões em formato " +
                            "hierárquico. Você pode responder a comentários específicos, " +
                            "navegar entre discussões de pais/filhos e visualizar a árvore.");
        System.out.println("=============================================================");

        exibirMenu();
    }

    public static void exibirFolhas(List<Comentario> folhas){
        System.out.println("=============================================================");
        System.out.println("COMENTÁRIOS SEM RESPOSTAS");
        System.out.println("=============================================================");
        if (folhas == null || folhas.isEmpty()) {
            System.out.println("Não existem comentários sem respostas no momento.");
        } else {
            for (Comentario f : folhas) {
                System.out.printf("[ID: %d] Autor: %s | Texto: %s%n", f.getId(), f.getAutor(), f.getTexto());
            }
        }
        System.out.println("=============================================================");
    }

    public static void exibirArvore(String arvoreTexto){
        System.out.println("=============================================================");
        System.out.println("ESTRUTURA COMPLETA DA ÁRVORE DE DISCUSSÃO");
        System.out.println("=============================================================");
        if (arvoreTexto == null || arvoreTexto.trim().isEmpty()) {
            System.out.println("(Árvore vazia)");
        } else {
            System.out.println(arvoreTexto);
        }
        System.out.println("=============================================================");
    }

    public static void limparTela(){

        for (int i = 0; i < 50; i++) {
            System.out.println();

        }
    }

    public static void exibirTotalComentarios(int total) {
        System.out.println("=============================================================");
        System.out.printf("Total de comentários na árvore: %d%n", total);
        System.out.println("=============================================================");
    }

    public static void exibirTotalPorAutor(String autor, int total) {
        System.out.println("=============================================================");
        System.out.printf("O usuário '%s' publicou um total de %d comentário(s).%n", autor, total);
        System.out.println("=============================================================");
    }

}