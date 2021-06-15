package br.com.postmon.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.postmon.domain.model.CidadeInfo;
import br.com.postmon.domain.model.EstadoInfo;
import br.com.postmon.domain.model.Principal;
import br.com.postmon.service.Servico;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicoTestUnit {

	@Autowired
	private Servico servico;

	@Test
	public void consumidorTest() {
		Principal principal = servico.consumidor();
		CidadeInfo cidadeInfo = principal.getCidadeInfo();
		EstadoInfo estadoInfo = principal.getEstadoInfo();

		// CidadeInfo TESTE
		assertEquals("5779,999", cidadeInfo.getArea());
		assertEquals("5300108", cidadeInfo.getCodigoIbge());

		// EstadoInfo TESTE
		assertEquals("5.779,999", estadoInfo.getArea());
		assertEquals("53", estadoInfo.getCodigoIbge());
		assertEquals("Distrito Federal", estadoInfo.getNome());

		// Principal TESTE
		assertEquals("Veneza I (Planaltina)", principal.getBairro());
		assertEquals("Brasília", principal.getCidade());
		assertEquals("DF", principal.getEstado());

	}
}
