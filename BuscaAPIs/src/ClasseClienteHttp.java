import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClasseClienteHttp {

    //Habilitar Conexão Http
    
    //Criando método tipo String "retornarBodyApi" com argumento a var urlApi
    public String retornarBodyApi(String urlApi) {
        
        //Criando Try para proteger o código de erro e retornar erro de excessão
        try {
            //Declarando variável tipo URI chamada uriapikeyvar e criando URI(Uniform Resource Identifier - URI é a padronização que Urls utilizam) da URL para passar no request
            URI uriApi = URI.create(urlApi);
        
            //Declarando variavel tipo httpclient chamada clientehttp criando um novo cliente http atraves do método newHttpClient(); da classe HttpClient
            HttpClient clienteHttp = HttpClient.newHttpClient();
        
            //Declarando variavel tipo httprequest chamada buildrequesturi e construindo request com metódo newbuilder passando URI da API
            //e construindo request através do metódo build com método GET
            HttpRequest buildrequesturi = HttpRequest.newBuilder(uriApi).GET().build();
        
            //Efetuar request com metodo GET atraves do metodo send via novo cliente criado chamado clientehttp,
            // com parâmetro de leitura BodyHandler String que vai manusear o BODY que vamos receber da API como uma string
            // armazenando numa variável tipo Httpresponse em formato <String> chamada responsegetrequest
            HttpResponse<String> responsegetrequest = clienteHttp.send(buildrequesturi, BodyHandlers.ofString());
        
            //Armazenando a resposta do request, o body do documento JSON que são os dados em forma de texto da API através do método body();
            String bodyApi = responsegetrequest.body();

            //Retornando String para retornarBodyApi
            return bodyApi;
        
            //Imprimindo body completo da API através da linha de comando do sistema"
            //System.out.println(bodyApi); Linha de comando comentada(Imprime o body recebido do Http request)

        } catch (IOException | InterruptedException msgException) {
            throw new RuntimeException(msgException);
        }

    }
    
}
