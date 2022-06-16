package br.com.learning.valentim.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.learning.valentim.spring.data.service.CargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoService cargoService;
	private Boolean system = true;

	public SpringDataApplication(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = sc.nextInt();
			if (action == 1) {
				cargoService.inicial(sc);
			} else {
				system = false;
			}

		}
		sc.close();
	}

}
