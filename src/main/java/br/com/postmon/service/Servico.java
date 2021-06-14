package br.com.postmon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.postmon.domain.model.Principal;

@Service
public class Servico {

	@Autowired
	private RestTemplate restTemplate;

	public Principal consumidor() {
		String url = "https://api.postmon.com.br/v1/cep/73365539";
		Principal principal = restTemplate.getForObject(url, Principal.class);

		return principal;
	}

}
