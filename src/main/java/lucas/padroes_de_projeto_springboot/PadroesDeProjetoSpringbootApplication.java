package lucas.padroes_de_projeto_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesDeProjetoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesDeProjetoSpringbootApplication.class, args);
	}

}
