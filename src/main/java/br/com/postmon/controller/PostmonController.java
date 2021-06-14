package br.com.postmon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postmon.domain.model.Principal;
import br.com.postmon.service.Servico;

@RestController
@RequestMapping("/myApi")
public class PostmonController {

	@Autowired
	private Servico servico;

	@GetMapping("consumer")
	public ResponseEntity<Principal> consumer() {
		Principal principal = servico.consumidor();
		return ResponseEntity.ok(principal);
	}

}
