    //Importando bibliotecas para uso das expressões regulares através da biblioteca principal chamada regex e outras adcionais
//expressões regulares vão auxiliar a ler o body e retirar somente as informações sem os colchetes, chaves, virgulas, aspas e etc.
//efetuando assim o parsing do documento json e armazenando os dados limpos em uma lista chave : valor
import java.util.ArrayList;
import java.util.HashMap;
//Importando bibliotecas para criar lista do body da API após ter efetuado o parser dos dados
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Declarando classe publica chamada "ClasseJsonBodyParser"
public class ClasseJsonBodyParser {

    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");
    //Declarando linha de código da lista publica para ser acessada de outros lugares com comando public
    //Criar lista fazendo parser do bodyapi
         //Criando lista com mapeamento "chave : valor" de uma chave tipo string, e um valor tipo string,
         //da função criada chamada funcaoParse com atributos: (String json)
    public List<Map<String, String>> funcaoParse(String jsonBodyResponse) {
        Matcher matcher = REGEX_ITEMS.matcher(jsonBodyResponse);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
    }

}