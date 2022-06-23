package br.com.learning.valentim.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.learning.valentim.spring.data.orm.Cargo;
import br.com.learning.valentim.spring.data.repository.CargoRepository;

@Service
public class CargoService {

	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner sc) {
		while (system) {
			System.out.println("Qual função de cargo deseja executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");


			int action = sc.nextInt();

			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletarPorId(sc);
				break;
			default:
				system = false;
				break;

			}

		}

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

	private void atualizar(Scanner sc) {
		System.out.println("ID");
		int id = sc.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = sc.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletarPorId(Scanner sc) {
		System.out.println("ID");
		int id = sc.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
