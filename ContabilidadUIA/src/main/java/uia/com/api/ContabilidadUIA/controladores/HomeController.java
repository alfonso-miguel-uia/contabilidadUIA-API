package uia.com.api.ContabilidadUIA.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HomeController {

	@RequestMapping("home")
	public String sayHello()
	{
		return "Hola desde Home";
	}
}
