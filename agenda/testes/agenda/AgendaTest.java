package agenda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
    
    private Agenda agenda;
    
    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
    }
    
    @Test
    public void testCadastraContato() {
        assertEquals("\nPOSICAO INVALIDA", agenda.cadastraContato(0, "Nome", "Sobrenome", "Telefone"));
        assertEquals("\nPOSICAO INVALIDA", agenda.cadastraContato(101, "Nome", "Sobrenome", "Telefone"));

        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, null, "Sobrenome", "Telefone"));
        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "", "Sobrenome", "Telefone"));
        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "Nome", null, "Telefone"));
        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "Nome", "", "Telefone"));
        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "Nome", "Sobrenome", null));
        assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "Nome", "Sobrenome", ""));

        assertEquals("\nCONTATO CADASTRADO COM SUCESSO", agenda.cadastraContato(1, "Nome", "Sobrenome", "Telefone"));
        assertEquals("\nCONTATO CADASTRADO COM SUCESSO", agenda.cadastraContato(1, "Nome", "Sobrenome", "Telefone"));
        assertEquals("\nCONTATO JA CADASTRADO", agenda.cadastraContato(2, "Nome", "Sobrenome", "Telefone"));
    }
    
    @Test
    public void testAdicionaFavorito() {
        Contato contato1 = new Contato("Nome1", "Sobrenome1", "1111-1111");
        Contato contato2 = new Contato("Nome2", "Sobrenome2", "2222-2222");
        Contato contato3 = new Contato("Nome3", "Sobrenome3", "3333-3333");
        Contato contato4 = new Contato("Nome4", "Sobrenome4", "4444-4444");

        assertEquals("\nCONTATO INVALIDO", agenda.adicionaFavorito(1, null));
        assertEquals("\nPOSICAO INVALIDA", agenda.adicionaFavorito(0, contato1));
        assertEquals("\nCONTATO ADICIONADO AOS FAVORITOS", agenda.adicionaFavorito(6, contato1));
        assertEquals("\nCONTATO JA ESTA NOS FAVORITOS", agenda.adicionaFavorito(1, contato1));
        assertEquals("\nCONTATO JA ESTA NOS FAVORITOS", agenda.adicionaFavorito(1, contato1));
        assertEquals("\nCONTATO ADICIONADO AOS FAVORITOS", agenda.adicionaFavorito(2, contato2));
        assertEquals("\nCONTATO ADICIONADO AOS FAVORITOS", agenda.adicionaFavorito(3, contato3));
        assertEquals("\nCONTATO ADICIONADO AOS FAVORITOS E ANTERIOR REMOVIDO", agenda.adicionaFavorito(2, contato4));
        assertNull(agenda.getContato(3));
    }
    
    @Test
    public void testIsFavorito() {
        Contato contatoFavorito = new Contato("Nome", "Sobrenome", "Telefone");
        Contato contatoNaoFavorito = new Contato("Outro", "Contato", "1234");

        agenda.adicionaFavorito(1, contatoFavorito);

        assertTrue(agenda.isFavorito(contatoFavorito));
        assertFalse(agenda.isFavorito(contatoNaoFavorito));
    }
    
    public void testRemoverFavorito() {
        Contato contato = new Contato("Nome", "Sobrenome", "Telefone");
        agenda.adicionaFavorito(1, contato);

        assertEquals("\nPOSICAO INVALIDA", agenda.removerFavorito(0));
        assertEquals("\nPOSICAO INVALIDA", agenda.removerFavorito(11));

        assertEquals("\nCONTATO REMOVIDO DOS FAVORITOS", agenda.removerFavorito(1));
        assertFalse(contato.isFavorito());

        assertEquals("\nCONTATO NAO ESTA NOS FAVORITOS", agenda.removerFavorito(1));
    }


}

