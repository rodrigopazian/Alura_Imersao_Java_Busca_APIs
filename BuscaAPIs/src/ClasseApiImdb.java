import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClasseApiImdb {

    public List<ClasseConteudo> retornaDadosNasa(String jsonBodyResponse) {

        //Extrair dados da API, fazer parsing dos dados JSON, ou XML ou CSV
        //Criar objeto que vai chamar a classe criada ClasseJsonBodyParser e trazer a lista parseada para a variável bodyApiParsed
        ClasseJsonBodyParser bodyApiParsed = new ClasseJsonBodyParser();
                
        //Criar lista fazendo parser do bodyapi
            //Criando lista com mapeamento "chave : valor" de uma chave tipo string, e um valor tipo string chamada listaNasaParseadaChaveValor
            //através do objeto bodyApiParsed que chama a classe ClasseJsonBodyParser usando o método e função chamada funcaoParse para
            //fazer o parsing do body da API em formato json que recebemos no request que foi denomeado jsonBody
        List<Map<String, String>> listaNasaParseadaChaveValor = bodyApiParsed.funcaoParse(jsonBodyResponse);

        //Criar lista vazia
        //List<nomedalista>  variavelDeArmazenamento da chave:valor = nova listaArray <Chave>(valor) vazios <>()
        List<ClasseConteudo> listaconteudoNasa = new ArrayList<>();

        //Preencher a lista vazia somente com as chaves:valor interessadas da listaNasaChaveValor
        for (Map<String, String> listaChaveNasa : listaNasaParseadaChaveValor) {
            //Cria string titulo e urlImagem atraves do metodo get extraindo o (valor) da lista chaveNasa,
            // com as respectivas chaves title e url
            String titulo = listaChaveNasa.get("title");
            String urlImagem = listaChaveNasa.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            //Armazena titulo e urlimagem na variavel valor
            var valor = new ClasseConteudo(titulo, urlImagem);
            listaconteudoNasa.add(valor);
        }

        //Retornar variavelDeArmazenamento da Lista com conteudo chave:valor interessados preenchida
        return listaconteudoNasa;

    } 
}
