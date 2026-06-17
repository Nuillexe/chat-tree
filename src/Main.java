import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);



        ComentarioTree ct= new ComentarioTree();
        Comentario comentarioAtual= ct.getRaiz();

        ForumService s= new ForumService(ct,sc);

        String comando="";

        UI.exibirTutorial();
        while(comentarioAtual!=null){
            if(comentarioAtual.isRaiz()){
                UI.exibirConvrsaPrincipal(ct);
            }else{
                UI.exibirComentario(comentarioAtual, ct.obterCaminho(comentarioAtual));
            }
            comando = s.lerComando(sc);

            switch(comando.toUpperCase()){

                case "C":
                    s.criarComentario(comentarioAtual);
                    break;

                case "E":
                    s.editarComentario(comentarioAtual);
                    break;

                case "D":
                    comentarioAtual =s.deletarComentarioAtual(comentarioAtual);
                    break;

                case "V":

                    int id =s.lerId(sc);
                    Comentario destino = ct.buscarPorId(id);

                    if (destino != null)
                        comentarioAtual = destino;
                    else{
                        System.out.println("Não exixte um comentario com esse ID");
                    }
                    break;

                case "B"://Voltar para comentario pai

                    if(comentarioAtual.getPai()!=null)
                        comentarioAtual = comentarioAtual.getPai();

                    break;

                case "F":
        //            UI.exibirFolhas(ct.listarFolhas());
                    break;

                case "A":
                    UI.exibirArvore(ct.gerarArvoreTexto());
                    break;

                case "M":
                    UI.exibirMenu();
                    break;

                case "U":
                    System.out.println("Digite o nome de quem vc quer ver todos os comentarios");
                    String nome=sc.nextLine();
                    //UI.exibirComentariosDoAutor(nome, ct.comentariosDoAutor(nome));
                    break;
                case "B0"://Voltar ao inicio/comentario raiz
                    comentarioAtual=ct.getRaiz();
                    break;

                case "S"://encerrar o programa
                    comentarioAtual=null;
                    break;
                default:

                    System.out.println("Comando Invalido");
            }

            s.pressionarEnterParaContinuar(sc);
            UI.limparTela();
        }

        System.out.println("Encerrando o chat...");
        s.pressionarEnterParaContinuar(sc);
    }
}