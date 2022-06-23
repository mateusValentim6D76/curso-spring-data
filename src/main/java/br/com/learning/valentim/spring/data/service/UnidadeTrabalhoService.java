package br.com.learning.valentim.spring.data.service;

import org.springframework.stereotype.Service;

import br.com.learning.valentim.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class UnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeDeTrabalhoRepository;
	
	public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeDeTrabalhoRepository = unidadeTrabalhoRepository;
	}
}
