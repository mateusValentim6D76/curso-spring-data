package br.com.learning.valentim.spring.data.service;

import org.springframework.stereotype.Service;

import br.com.learning.valentim.spring.data.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository){
		this.funcionarioRepository = funcionarioRepository;
	}

}
