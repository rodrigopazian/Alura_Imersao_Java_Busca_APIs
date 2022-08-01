public class ClasseConteudo {
    
    //Criando variáveis privadas para restringir acesso as váriaveis somente ao código desta classe ClasseConteudo,
    //e utilizando comandando final para que a variável se torne imutável
    private final String titulo;
    private final String urlImagem;

    
    //Construindo Objeto chamado ObjetoConteudo passando atributos titulo e urlImagem 
    public ClasseConteudo(String titulo, String urlImagem) {
        //this.titulo e this.urlImagem transforma o chamado do objeto criado "ObjetoCounteudo" para titulo e urlImagem,
        //e iguala ao valor do atributo respectivamente
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }
    
    
    //Gerando Getters para expôr os atributos titulo e urlImagem para acesso de fora da classe ClasseConteudo
    public String retornoTitulo() {
        return titulo;
    }
    public String retornoUrlImagem() {
        return urlImagem;
    }
        
}