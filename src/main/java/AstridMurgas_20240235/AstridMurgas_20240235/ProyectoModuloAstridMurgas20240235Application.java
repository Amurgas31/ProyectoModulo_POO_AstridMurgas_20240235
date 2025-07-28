package AstridMurgas_20240235.AstridMurgas_20240235;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoModuloAstridMurgas20240235Application {

	public static void main(String[] args) {
		//Carga variables del .env al sistema
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		//Mantener linea existente
		SpringApplication.run(ProyectoModuloAstridMurgas20240235Application.class, args);
	}
}
