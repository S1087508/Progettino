package analisiPaesiController;

import org.springframework.web.bind.annotation.RestController;
import database.datiPaesi;
import modello.Dati;
import modello.MetaDati;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**§
 * 
 * @author Rumy
 *
 */

@RestController
public class paesiRestController { 
	@RequestMapping(value = "metadati", method=RequestMethod.GET)
	public ArrayList<MetaDati> getMetaDati(){
		
		return datiPaesi.getArrayMetaDati();
	}
}
		
	
	

