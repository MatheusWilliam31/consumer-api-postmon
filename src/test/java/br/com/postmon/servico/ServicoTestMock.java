package br.com.postmon.servico;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import br.com.postmon.domain.model.CidadeInfo;
import br.com.postmon.domain.model.EstadoInfo;
import br.com.postmon.domain.model.Principal;
import br.com.postmon.service.Servico;

@RunWith(MockitoJUnitRunner.class)
public class ServicoTestMock {

	private Servico servico;
	private static final String URL = "https://api.postmon.com.br/v1/cep/73365539";

	@Mock
	private RestTemplate restTemplate;

	@Before
	public void before() {
		servico = new Servico(restTemplate);
	}

	@Test
	public void consumerTestMock() {

		Principal principal = returnApi();
		BDDMockito.given(restTemplate.getForObject(URL, Principal.class)).willReturn(principal);

		servico.consumidor();
		BDDMockito.verify(restTemplate).getForObject(URL, Principal.class);
	}

	private Principal returnApi() {
		Principal principal = new Principal();
		CidadeInfo cidadeInfo = new CidadeInfo();
		EstadoInfo estadoInfo = new EstadoInfo();

		cidadeInfo.setArea("5779,999");
		cidadeInfo.setCodigoIbge("5300108");

		estadoInfo.setArea("5.779,999");
		estadoInfo.setCodigoIbge("53");
		estadoInfo.setNome("Distrito Federal");

		principal.setBairro("Veneza I (Planaltina)");
		principal.setCidade("Brasília");
		principal.setEstado("DF");

		principal.setCidadeInfo(cidadeInfo);
		principal.setEstadoInfo(estadoInfo);

		return principal;
	}
}
