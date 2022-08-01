import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Declarando variavel tipo string para armazenar endereço da API com a chave
        //IMDB
        //String urlapikeyvar = "https://imdb-api.com/en/API/Top250Movies/k_cgnrz994"; //API imdb caindo server erro 403
        //String urlApi = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; //API alternativa 250 filmes
        //IMDB Extrator dados
        //ClasseApiImdb dadosApis = new ClasseApiImdb();
        //NASA
        //String urlApi = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; //API Nasa alternativa
        String urlApi = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json"; //API Nasa alternativa
        //NASA Extrator dados
        ClasseApiNasa dadosApis = new ClasseApiNasa();

        ClasseClienteHttp respostaHttp = new ClasseClienteHttp();
        String jsonBodyResponse = respostaHttp.retornarBodyApi(urlApi);

        //Exibir dados
        //IMDB
        //ClasseApiImdb dadosImdb = new ClasseApiImdb();
        List<ClasseConteudo> listadadosNasa = dadosApis.retornaDadosNasa(jsonBodyResponse);

        
        
        ClasseGeradoraSticker criaImg = new ClasseGeradoraSticker();
        
        for (int i = 0; i<3; i++) {
            ClasseConteudo listaApis = listadadosNasa.get(i);

            InputStream bytesDados = new URL(listaApis.retornoUrlImagem()).openStream();
            String nomeArquivo = "assets/" + listaApis.retornoTitulo() + ".png";

            criaImg.funcaoCriarSticker(bytesDados, nomeArquivo);

            System.out.println(listaApis.retornoTitulo());
            System.out.println();


        }
        //Imprime no terminal número total de itens da lista(filmes)
        System.out.println(listadadosNasa.size());
        //System.out.println();
        //Imprime no terminal item número 0 da lista(filmes) fora de ordem
        //System.out.println(listaDeFilmes.get(0)); Linha de comando comentada
    }
}
