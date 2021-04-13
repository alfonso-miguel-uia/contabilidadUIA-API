package uia.com.api.ContabilidadUIA.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uia.com.api.ContabilidadUIA.modelo.ClientesRepositorio;
import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})

public class ClientesController {
	  
	    /**
	     * Get all Clientes
	     * @return a controller
	     */
	
	private ClientesRepositorio clientes = new ClientesRepositorio();
	  

	  @RequestMapping(value="clientes",method = RequestMethod.GET)
	  public ResponseEntity<List<InfoUIA>> getAllClientes() {
		  System.out.println("Saludos desde getAllClientes()");
	        return ResponseEntity.ok(clientes.getListaProveedores());
		  
	  }
	  
	  
	  	/**
	     * Get a Clientes by clienteId
	     * @param clienteId
	     * @return a controller
	     */
	  @RequestMapping(value="clientes/{clienteId}",method = RequestMethod.GET)
	    public ResponseEntity<InfoUIA> clienteById(@PathVariable String clienteId)  throws  ClassNotFoundException{
		  System.out.println("Saludos desde clienteById()");
	        return ResponseEntity.ok((InfoUIA)clientes.getProveedor(clienteId));
		  
	  }
	  
	  
	  /**
	     * Save a new cliente
	     * @param cliente
	     * @return
	     */
	  @RequestMapping(value="clientes",method = RequestMethod.POST)
	    public  ResponseEntity<Object> agregaCliente(@RequestBody InfoUIA newCliente){
			  System.out.println("Saludos desde agregaCliente()");
		        return ResponseEntity.ok((InfoUIA)clientes.agregaCatalogo(newCliente));
	    }

	  
	}