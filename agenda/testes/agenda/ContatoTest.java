package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {
    private Contato contatoBase;


    @BeforeEach
    void preparaContatos() {
        this.setContatoBase(new Contato("Matheus", "Gaudencio", "555-5551"));
    }

    @Test
    public void testSetNome() {
        Contato contato = new Contato("João", "Silva", "1111-1111");
        contato.setNome("Maria");
        assertEquals("Maria", contato.getNome());
    }

    @Test
    public void testSetSobrenome() {
        Contato contato = new Contato("João", "Silva", "1111-1111");
        contato.setSobrenome("Souza");
        assertEquals("Souza", contato.getSobrenome());
    }

    @Test
    public void testSetTelefone() {
        Contato contato = new Contato("João", "Silva", "1111-1111");
        contato.setTelefone("2222-2222");
        assertEquals("2222-2222", contato.getTelefone());
    }


    @Test
    public void testToString() {
        Contato contato = new Contato("João", "Silva", "1111-1111");
        assertEquals("João Silva - 1111-1111", contato.toString());
    }

    @Test
    public void testExibirContato() {
        Contato contato = new Contato("João", "Silva", "1111-1111");
        String mensagem = contato.exibirContato(false);
        assertEquals("Nome completo: João Silva\nTelefone: 1111-1111\n", mensagem);
    }

	public Contato getContatoBase() {
		return contatoBase;
	}

	public void setContatoBase(Contato contatoBase) {
		this.contatoBase = contatoBase;
	}
}
