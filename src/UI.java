import java.util.LinkedList;
import java.util.List;

public class UI {

    public static void exibirComentario(Comentario comentario, String caminho){
        System.out.println("=============================================================");
        System.out.printf("Caminho: %s%n", caminho);
        System.out.printf("ID: %d%n", comentario.getId());
        System.out.printf("Autor: %s%n", comentario.getAutor());
        System.out.printf("Texto:%s%n", comentario.getTexto());
        System.out.printf("N° de Respostas: %d%n", comentario.getQuantidadeRespostas());

        System.out.println("=============================================================");

        // Comentários filhos diretos
        if (comentario.getQuantidadeRespostas() > 0) {
            System.out.println("Respostas diretas :");
            for (Comentario filho : comentario.getRespostas()) {
                System.out.printf("  -> " + filho);
            }
            System.out.println("=============================================================");
        }
    }

    public static void exibirComentarios(LinkedList<Comentario> listaComentarios){
        /*fazer algo semelhante a impressão de comentarios filhos. Fazer caso parametrro seja null e falar que esse
        autor n existe*/

    }
    public static void exibirConvrsaPrincipal(ComentarioTree ct){
        Comentario raiz=ct.getRaiz();
        System.out.printf("Texto:%s%n", raiz.getTexto());
        System.out.printf("Total de comentarios do Forum: %d%n", 0/*ct.contarComentarios()*/);
        System.out.println("=============================================================");
        System.out.printf("N° de Comentarios: %d%n", raiz.getQuantidadeRespostas());
        // Comentários filhos diretos
        if (raiz.getQuantidadeRespostas() > 0) {
            System.out.println("Comentarios :");
            for (Comentario filho : raiz.getRespostas()) {
                System.out.println("  -> " + filho);
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

    public static void exibirTutorial(){
        System.out.println("=============================================================");
        System.out.println("    SISTEMA DE FÓRUM EM ÁRVORE (DISCUSSÃO ENCADEADA)         ");
        System.out.println("=============================================================");
        System.out.println("Bem-vindo! Este sistema permite organizar discussões em formato " +
                            "hierárquico. Você pode responder a comentários específicos, " +
                            "navegar entre discussões e visualizar a árvore.");
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