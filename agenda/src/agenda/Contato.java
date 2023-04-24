package agenda;
/**
*Representa um contato da agenda telefônica, contendo nome, sobrenome, telefone e se é um favorito ou não.
*/
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean isFavorito;
    /**

    *Cria um novo contato com o nome, sobrenome e telefone especificados e define que não é um favorito.
    *@param nome o nome do contato
    *@param sobrenome o sobrenome do contato
    *@param telefone o telefone do contato
    */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.isFavorito = false;
    }
    /**
    *Retorna o nome do contato.
    *@return o nome do contato
    */
    public String getNome() {
        return nome;
    }
    /**

    *Retorna o sobrenome do contato.
    *@return o sobrenome do contato
    */
    public String getSobrenome() {
        return sobrenome;
    }
    /**

    *Retorna o telefone do contato.
    *@return o telefone do contato
    */
    public String getTelefone() {
        return telefone;
    }
  
    /**

    *Define o nome do contato.
    *@param nome o novo nome do contato
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**

    *Define o sobrenome do contato.
    *@param sobrenome o novo sobrenome do contato
    */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    /**

    *Define o telefone do contato.
    *@param telefone o novo telefone do contato
    */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
    *Verifica se o contato é um favorito.
    *@return true se o contato é um favorito, false caso contrário
    */
    public boolean isFavorito() {
        return isFavorito;
    }
    /**
    *Define se o contato é um favorito ou não.
    *@param favorito true se o contato deve ser marcado como um favorito, false caso contrário
    */
    public void setFavorito(boolean favorito) {
        isFavorito = favorito;
    }
    /**

    *Verifica se o nome completo do contato começa com um determinado prefixo.
    *@param prefix o prefixo a ser verificado
    *@return true se o nome completo do contato começa com o prefixo, false caso contrário
    */
    public boolean startsWith(String prefix) {
        return (this.nome + " " + this.sobrenome).startsWith(prefix);
    }
    /**

    *Retorna uma representação em string do contato, contendo nome, sobrenome e telefone.
    *@return uma string contendo nome, sobrenome e telefone do contato
    */
    @Override
    public String toString() {
        return nome + " " + sobrenome + " - " + telefone;
    }
    /**

    *Gera uma mensagem de exibição para o contato, incluindo nome completo e telefone.
    *@param isFavorito um booleano indicando se o contato é um favorito
    *@return uma String contendo a mensagem de exibição do contato
    */
    public String exibirContato(boolean isFavorito) {
        StringBuilder mensagem = new StringBuilder();
        if (isFavorito) {
            mensagem.append("🧡 ");
        }
        mensagem.append("Nome completo: ")
               .append(nome)
               .append(" ")
               .append(sobrenome)
               .append("\n")
               .append("Telefone: ")
               .append(telefone)
               .append("\n");
        return mensagem.toString();
    }
}
