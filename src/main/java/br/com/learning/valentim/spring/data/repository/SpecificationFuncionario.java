package br.com.learning.valentim.spring.data.repository;

import org.springframework.data.jpa.domain.Specification;

import br.com.learning.valentim.spring.data.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome){
		return 
				(root, criteriaApi, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
}
