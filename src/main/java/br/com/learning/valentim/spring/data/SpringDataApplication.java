package br.com.learning.valentim.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.learning.valentim.spring.data.service.CargoService;
import br.com.learning.valentim.spring.data.service.FuncionarioService;
import br.com.learning.valentim.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.learning.valentim.spring.data.service.RelatorioService;
import br.com.learning.valentim.spring.data.service.UnidadeTrabalhoService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CargoService cargoService;

	private final RelatorioService relatoriosService;

	private final FuncionarioService funcionarioService;

	private final UnidadeTrabalhoService unidadeTrabalhoService;

	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public SpringDataApplication(CargoService cargoService, RelatorioService relatoriosService,
			FuncionarioService funcionarioService, UnidadeTrabalhoService unidadeTrabalhoService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.relatoriosService = relatoriosService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios dinamicos");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatoriosService.inicial(scanner);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
		}
	}
}
