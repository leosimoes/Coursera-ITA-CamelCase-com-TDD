package testes;

//@author Leonardo Simões
import org.junit.*;
import static org.junit.Assert.*;
import programa.CamelCase;
import java.util.Arrays;

public class TestCamelCase {

    @Test
    public void semPalavras() {
        assertTrue(CamelCase.converterCamelCase("").isEmpty());
        assertTrue(CamelCase.converterCamelCase(null).isEmpty());
    }

    @Test
    public void umaPalavra() {
        assertEquals(Arrays.asList("nome"), CamelCase.converterCamelCase("nome"));
        assertEquals(Arrays.asList("nome"), CamelCase.converterCamelCase("Nome"));
        assertEquals(Arrays.asList("CPF"), CamelCase.converterCamelCase("CPF"));
    }

    @Test
    public void nPalavras() {
        Arrays.asList("nome", "composto");
        assertEquals(Arrays.asList("nome", "composto"),
                CamelCase.converterCamelCase("nomeComposto"));
        assertEquals(Arrays.asList("nome", "composto"),
                CamelCase.converterCamelCase("NomeComposto"));
        assertEquals(Arrays.asList("nome", "CPF"),
                CamelCase.converterCamelCase("NomeCPF"));
        assertEquals(Arrays.asList("nome", "CPF", "contribuinte"),
                CamelCase.converterCamelCase("nomeCPFContribuinte"));
        assertEquals(Arrays.asList("recupera", "10", "primeiros"),
                CamelCase.converterCamelCase("recupera10Primeiros"));
    }

}
