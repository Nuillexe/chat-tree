import java.util.LinkedList;
import java.util.List;

public class UI {

    public static void exibirComentario(Comentario comentario, String caminho){
        imprimirLinhaSeparadora();
        System.out.printf("Caminho: %s%n", caminho);
        System.out.printf("ID: %d%n", comentario.getId());
        System.out.printf("Autor: %s%n", comentario.getAutor());
        System.out.printf("Texto:%s%n", comentario.getTexto());
        System.out.printf("N° de Respostas: %d%n", comentario.getQuantidadeRespostas());

        imprimirLinhaSeparadora();

        mostrarRespostas(comentario,"     ");

    }

    private static void mostrarRespostas(Comentario c, String espaco){
        if(c.getQuantidadeRespostas()>0){
            listarRespostas(c, espaco);
        }else{
            System.out.println("--Não há comentarios--");
        }
    }

    private static void listarRespostas(Comentario comentario, String espaco){
        if(comentario.getQuantidadeRespostas()>0){
            for (int i = 0; i < comentario.getRespostas().size(); i++) {
                Comentario filho = comentario.getRespostas().get(i);

                String marcador =
                        (i == comentario.getRespostas().size() - 1)
                                ? "└── "
                                : "├── ";

                System.out.println(espaco + marcador + filho);

                if (!filho.getRespostas().isEmpty()) {
                    mostrarRespostas(filho, espaco + "│   ");
                }
            }
        }
        System.out.println();
    }

    public static void exibirConvrsaPrincipal(ComentarioTree ct){
        Comentario raiz=ct.getRaiz();
        System.out.printf("Total de comentarios do Forum: %d%n", ct.contarComentarios());
        System.out.println( raiz.getTexto() + " (ID: "+raiz.getId()+")");
        mostrarRespostas(raiz,"     ");

    }

    public static void exibirComentariosDoAutor(String nome, LinkedList<Comentario> listaComentarios){
        imprimirLinhaSeparadora();
        System.out.printf("COMENTÁRIOS PUBLICADOS POR: %s%n", nome.toUpperCase());
        imprimirLinhaSeparadora();

        // Validação de lista nula
        if (listaComentarios == null || listaComentarios.isEmpty()) {
            System.out.printf("Erro: O autor '%s' não existe no sistema ou não possui comentários.%n", nome);
            imprimirLinhaSeparadora();
            return;
        }

        // Comentários encontrados
        for (Comentario c : listaComentarios) {
            System.out.printf("[ID: %d] Texto: %s%n", c.getId(), c.getTexto());

            // Verifica se há um comentário pai
            if (c.getPai() != null && c.getPai().getAutor() != null && !c.getPai().getAutor().isEmpty()) {
                System.out.printf("  ↳ Em resposta a: %s (ID: %d)%n", c.getPai().getAutor(), c.getPai().getId());
            } else if (c.getPai() != null) {
                System.out.println("  ↳ Em resposta à raiz da discussão.");
            }
            imprimirLinhaSeparadora();
        }

        System.out.printf("Total de ocorrências encontradas: %d%n", listaComentarios.size());
        imprimirLinhaSeparadora();
    }

    public static void exibirMenu(){
        imprimirLinhaSeparadora();
        System.out.println("Menu de Comandos");
        imprimirLinhaSeparadora();
        System.out.println("C - Criar comentário");
        System.out.println("D - Deletar comentário");
        System.out.println("E - Editar comentário");
        System.out.println("V - Visitar comentário filho");
        System.out.println("B - Voltar ao comentário pai");
        System.out.println("F - Mostrar folhas");
        System.out.println("A - Mostrar árvore completa");
        System.out.println("U - Mostrar total de comentários de um usuário");

        System.out.println("M - Mostrar menu");
        imprimirLinhaSeparadora();
    }

    public static void exibirTutorial(){
        imprimirLinhaSeparadora();
        System.out.println("    SISTEMA DE FÓRUM EM ÁRVORE (DISCUSSÃO ENCADEADA)         ");
        imprimirLinhaSeparadora();
        System.out.println("Bem-vindo! Este sistema permite organizar discussões em formato " +
                "hierárquico. Você pode responder a comentários específicos, " +
                "navegar entre discussões e visualizar a árvore.");
        imprimirLinhaSeparadora();

        exibirMenu();
        System.out.println();
    }

    public static void exibirFolhas(List<Comentario> folhas){
        imprimirLinhaSeparadora();
        System.out.println("COMENTÁRIOS SEM RESPOSTAS");
        imprimirLinhaSeparadora();
        if (folhas == null || folhas.isEmpty()) {
            System.out.println("Não existem comentários sem respostas no momento.");
        } else {
            for (Comentario f : folhas) {
                System.out.printf("[ID: %d] Autor: %s | Texto: %s%n", f.getId(), f.getAutor(), f.getTexto());
            }
        }
        imprimirLinhaSeparadora();
    }

    public static void exibirArvore(String arvoreTexto){
        imprimirLinhaSeparadora();
        System.out.println("ESTRUTURA COMPLETA DA ÁRVORE DE DISCUSSÃO");
        imprimirLinhaSeparadora();
        if (arvoreTexto == null || arvoreTexto.trim().isEmpty()) {
            System.out.println("(Árvore vazia)");
        } else {
            System.out.println(arvoreTexto);
        }
        imprimirLinhaSeparadora();
    }

    public static void limparTela(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void exibirTotalComentarios(int total) {
        imprimirLinhaSeparadora();
        System.out.printf("Total de comentários na árvore: %d%n", total);
        imprimirLinhaSeparadora();
    }

    public static void exibirTotalPorAutor(String autor, int total) {
        imprimirLinhaSeparadora();
        System.out.printf("O usuário '%s' publicou um total de %d comentário(s).%n", autor, total);
        imprimirLinhaSeparadora();
    }

    private static void imprimirLinhaSeparadora() {
        System.out.println("=============================================================");

    }

    private static void listarRespostasDiretas(List<Comentario> respostas) {
        for (Comentario child : respostas) {
            System.out.println("  -> " + child);
        }
        imprimirLinhaSeparadora();
    }
}