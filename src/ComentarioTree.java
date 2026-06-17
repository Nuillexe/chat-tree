import java.util.LinkedList;
import java.util.List;

class ComentarioTree {

    private Comentario raiz;

    public ComentarioTree(){
        raiz = new Comentario("", "FORUM", null);
    }

    public Comentario getRaiz() {
        return raiz;
    }


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

    public String obterCaminho(Comentario comentario) {
        if (comentario.getPai() == null) {
            return "FORUM";
        }

        return obterCaminho(comentario.getPai())
                + " > "
                + comentario.getId()
                + " (" + comentario.getAutor() + ")";
    }


    public LinkedList<Comentario> comentariosDoAutor(String nomeDoAutor) {
        LinkedList<Comentario> resultado = new LinkedList<>();
        comentariosDoAutorRecursivo(raiz, nomeDoAutor, resultado);

        if (resultado.isEmpty()) {
            return null;
        }

        return resultado;
    }

    private void comentariosDoAutorRecursivo(
            Comentario atual,
            String nomeDoAutor,
            LinkedList<Comentario> resultado) {

        if (atual == null) {
            return;
        }

        if (atual.getAutor().equalsIgnoreCase(nomeDoAutor)) {
            resultado.add(atual);
        }

        for (Comentario filho : atual.getRespostas()) {
            comentariosDoAutorRecursivo(filho, nomeDoAutor, resultado);
        }
    }


    public String gerarArvoreTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("DISCUSSÃO\n");
        gerarArvoreRecursivo(raiz, "", sb);
        return sb.toString();
    }

    private void gerarArvoreRecursivo(Comentario atual, String prefixo, StringBuilder sb) {
        List<Comentario> filhos = atual.getRespostas();
        int total = filhos.size();

        for (int i = 0; i < total; i++) {
            Comentario filho = filhos.get(i);
            boolean ehUltimo = (i == total - 1);

            String conector = ehUltimo ? "└── " : "├── ";
            sb.append(prefixo).append(conector).append(filho.getId()).append("\n");

            String novoPrefixo = prefixo + (ehUltimo ? "    " : "│   ");
            gerarArvoreRecursivo(filho, novoPrefixo, sb);
        }
    }


    public List<Comentario> listarFolhas() {
        List<Comentario> folhas = new LinkedList<>();
        listarFolhasRecursivo(raiz, folhas);
        return folhas;
    }

    private void listarFolhasRecursivo(Comentario atual, List<Comentario> folhas) {
        if (atual == null) {
            return;
        }

        // Se o nó atual não possui respostas e não é a raiz ("FORUM"), ele é uma folha
        if (atual.getRespostas().isEmpty() && !atual.isRaiz()) {
            folhas.add(atual);
        }

        // Percorre cada filho chamando a função recursivamente
        for (Comentario filho : atual.getRespostas()) {
            listarFolhasRecursivo(filho, folhas);
        }
    }

    /**
     * Retorna a quantidade total de comentários da árvore (excluindo a raiz "FORUM").
     */
    public int contarComentarios() {
        int total = contarComentariosRecursivo(raiz);
        return total - 1; // Remove o nó inicial "FORUM" da contagem final
    }

    private int contarComentariosRecursivo(Comentario atual) {
        if (atual == null) {
            return 0;
        }

        int contador = 1; // Conta o nó atual

        // Soma recursivamente o contador de cada filho
        for (Comentario filho : atual.getRespostas()) {
            contador += contarComentariosRecursivo(filho);
        }

        return contador;
    }
}


