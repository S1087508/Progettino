package covid19.analisiPaesi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Esegue l'applicazione Spring e scarica i dati dei paesi.
 * 
 * @author Rumeysa Nur Gulesin
 */

@SpringBootApplication
public class AnalisiPaesiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AnalisiPaesiApplication.class, args);
		covid19.analisiPaesi.database.DatiPaesi.scaricaDatiPaesi();
	}

}
