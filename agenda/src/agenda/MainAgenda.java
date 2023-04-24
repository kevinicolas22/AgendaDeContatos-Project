package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
            cadastraContato(agenda, scanner);
            break;
        case "L":
            listaContatos(agenda);
            break;
        case "E":
            exibeContato(agenda, scanner);
            break;
        case "F":
            exibirFavoritos(agenda);
            break; 
        case "A":
        	adicionaFavorito(agenda, scanner);
        	break;
        case "R":
        	removerFavorito(agenda, scanner);
        	break;
        case "S":
            sai();
            break;
        default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**

	*Exibe as informações de um contato da agenda.
	*@param agenda a agenda de contatos a ser consultada
	*@param scanner o scanner utilizado para ler a entrada do usuário
	*/
	public static void exibeContato(Agenda agenda, Scanner scanner) {
	    System.out.print("\nQual contato> ");
	    int posicao = scanner.nextInt();
	    scanner.nextLine();
	    Contato contato = agenda.getContato(posicao);
	    if (contato == null) {
	        System.out.println("\nPOSICAO INVALIDA!");
	    } else {
	        boolean isFavorito = agenda.isFavorito(contato);
	        System.out.println(contato.exibirContato(isFavorito));
	    }
	}
	
	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contatos O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contatos) {
		return posicao + " - " + contatos;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNome> ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
	}
	
	/**
	 * Imprime a lista de favoritos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void exibirFavoritos(Agenda agenda) {
	    System.out.println("\nLista de favoritos: ");
	    Contato[] favoritos = agenda.getFavoritos();
	    for (int i = 0; i < favoritos.length; i++) {
	        if (favoritos[i] != null) {
	            System.out.println(formataContato(i+1, favoritos[i]));
	        }
	    }
	}


	/**

	Adiciona um contato à lista de favoritos em uma determinada posição.
	@param agenda a agenda de contatos.
	@param scanner o objeto Scanner para ler a entrada do usuário.
	*/
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
	    System.out.print("\nQual contato adicionar> ");
	    int posicao = scanner.nextInt();
	    scanner.nextLine();
	    Contato contato = agenda.getContato(posicao);
	    if (contato == null) {
	        System.out.println("\nPOSICAO INVALIDA!");
	    } else {
	        System.out.print("\nQual a posição nos favoritos> ");
	        int posicaoFavoritos = scanner.nextInt();
	        scanner.nextLine();
	        String resultado = agenda.adicionaFavorito(posicaoFavoritos, contato);
	        System.out.println(resultado);
	    }
	}

	
	/**

	*Método responsável por remover um contato da lista de favoritos da agenda.
	*@param agenda a agenda a ser manipulada
	*@param scanner o Scanner para leitura de dados do usuário
	*/
	private static void removerFavorito(Agenda agenda, Scanner scanner) {
	    System.out.print("\nPosição do contato na agenda de favoritos> ");
	    int posicao = scanner.nextInt();
	    scanner.nextLine();
	    String resultado = agenda.removerFavorito(posicao);
	    System.out.println(resultado);
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
