package covid19.analisiPaesi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Rumy
 *
 */

@SpringBootApplication
public class AnalisiPaesiApplication 
{

/**
 * 
 * @param args
 * @throws IOException 
 */
	
	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(AnalisiPaesiApplication.class, args);
		database.datiPaesi.scaricaDatiPaesi();
	}

}
