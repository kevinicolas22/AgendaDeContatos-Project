package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	
	protected Contato[] contatos; //apenas uma simplificacao de contato
	protected Contato[] favoritos;

	
	/**
	 * Cria uma agenda.
	 */ 
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato [TAMANHO_FAVORITOS];

	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**

	*Cadastra um contato na posição especificada da agenda.
	*@param posicao a posição em que o contato deve ser cadastrado.
	*@param nome o nome do contato a ser cadastrado.
	*@param sobrenome o sobrenome do contato a ser cadastrado.
	*@param telefone o telefone do contato a ser cadastrado.
	*@return uma mensagem indicando se o contato foi cadastrado com sucesso ou se ocorreu algum erro.
	*/
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
	    if (posicao < 1 || posicao > 100) {
	        return "\nPOSICAO INVALIDA";
	    }
	    for (int i = 0; i < TAMANHO_AGENDA; i++) {
	        if (i != posicao && contatos[i] != null && contatos[i].startsWith(nome + " " + sobrenome)) {
	            return "\nCONTATO JA CADASTRADO";
	        }
	    }
	    if (nome == null || nome.trim().isEmpty() || sobrenome == null || sobrenome.trim().isEmpty() || telefone == null || telefone.trim().isEmpty()) {
	        return "\nCONTATO INVALIDO";
	    }
	    this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	    return "\nCONTATO CADASTRADO COM SUCESSO";
	}

	/**
	 * Acessa a lista de contatos favoritos.
	 * @return O array de contatos favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	/**

	*Adiciona um contato à lista de favoritos na posição especificada.
	*Se a posição estiver fora do intervalo permitido, retorna uma mensagem de erro.
	*Se o contato já estiver na lista de favoritos, retorna uma mensagem informando isso.
	*Caso contrário, adiciona o contato na posição especificada e retorna uma mensagem de sucesso.
	*Se a posição já estiver ocupada, o contato anterior é removido da lista de favoritos.
	*@param posicao A posição na lista de favoritos onde o contato será adicionado.
	*@param contato O contato a ser adicionado aos favoritos.
	*@return Uma mensagem informando se o contato foi adicionado com sucesso, se já estava na lista ou se ocorreu um erro.
	*/
	
	public String adicionaFavorito(int posicao, Contato contato) {
	    if (posicao < 1 || posicao > TAMANHO_FAVORITOS) {
	        return "\nPOSICAO INVALIDA";
	    }
	    for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
	        if (i != posicao-1 && favoritos[i] != null && favoritos[i].equals(contato)) {
	            return "\nCONTATO JA ESTA NOS FAVORITOS";
	        }
	    }
	    for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
	        if (this.favoritos[i] != null && this.favoritos[i].equals(contato)) {
	            contato.setFavorito(true);
	            this.favoritos[i] = contato;
	            return "\nCONTATO ATUALIZADO NOS FAVORITOS";
	        }
	    }
	    if (contato == null) {
	        return "\nCONTATO INVALIDO";
	    }
	    if (this.favoritos[posicao-1] == null) {
	        contato.setFavorito(true);
	        this.favoritos[posicao-1] = contato;
	        return "\nCONTATO ADICIONADO AOS FAVORITOS";
	    } else {
	        Contato antigo = this.favoritos[posicao-1];
	        contato.setFavorito(true);
	        this.favoritos[posicao-1] = contato;
	        for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
	            if (this.favoritos[i] != null && this.favoritos[i].equals(antigo) && i != posicao-1) {
	                this.favoritos[i] = null;
	                break;
	            }
	        }
	        return "\nCONTATO ADICIONADO AOS FAVORITOS E ANTERIOR REMOVIDO";
	    }
	}

	public boolean isFavorito(Contato contato) {
	    for (Contato favorito : favoritos) {
	        if (favorito != null && favorito.equals(contato)) {
	            return true;
	        }
	    }
	    return false;
	}

	/**

	*Remove um contato da lista de favoritos na posição especificada.
	*@param posicao a posição do contato na lista de favoritos a ser removido
	*@return uma mensagem indicando se a remoção foi realizada com sucesso ou se houve um erro (posição inválida ou contato não está nos favoritos)
	*/

	public String removerFavorito(int posicao) {
	    if (posicao < 1 || posicao > TAMANHO_FAVORITOS) {
	        return "\nPOSICAO INVALIDA";
	    }
	    if (this.favoritos[posicao-1] == null) {
	        return "\nCONTATO NAO ESTA NOS FAVORITOS";
	    } else {
	        this.favoritos[posicao-1] = null;
	        return "\nCONTATO REMOVIDO DOS FAVORITOS";
	    }
	}

	public int carregaContatos(String string, Agenda agenda) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
