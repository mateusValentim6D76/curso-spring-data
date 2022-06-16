package br.com.learning.valentim.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.learning.valentim.spring.data.orm.Cargo;
import br.com.learning.valentim.spring.data.repository.CargoRepository;

@Service
public class CargoService {

	private final CargoRepository cargoRepository;
	
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
		
	public void inicial(Scanner sc) {
		salvar(sc);
	}

	private void salvar(Scanner sc) {
		System.out.println("Digite o cargo");
		String descricaoCargo = sc.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricaoCargo);
		cargoRepository.save(cargo);
		System.out.println("INFORMAÇÃO DO CARGO SALVA !");
		
	}
}
