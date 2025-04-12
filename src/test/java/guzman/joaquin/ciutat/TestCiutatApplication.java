package guzman.joaquin.ciutat;

import org.springframework.boot.SpringApplication;

public class TestCiutatApplication {

	public static void main(String[] args) {
		SpringApplication.from(CiutatApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
