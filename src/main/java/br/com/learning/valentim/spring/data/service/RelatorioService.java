package br.com.learning.valentim.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.learning.valentim.spring.data.orm.Funcionario;
import br.com.learning.valentim.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioService {

	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private final FuncionarioRepository funcionarioRepository;

	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner sc) {
		while (system) {
			System.out.println("Qual ação de cargo deseja executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");

			int action = sc.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(sc);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(sc);
				break;
			case 3:
				buscaFuncionarioDataContratacao(sc);
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void buscaFuncionarioNome(Scanner sc) {
		System.out.println("Qual nome deseja pesquisar ?");
		String nome = sc.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}

	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();

		System.out.println("Qual data contratacao deseja pesquisar");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);

		System.out.println("Qual salario deseja pesquisar");
		Double salario = scanner.nextDouble();

		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		list.forEach(System.out::println);
	}

	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Qual data contratacao deseja pesquisar");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);

		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
}
