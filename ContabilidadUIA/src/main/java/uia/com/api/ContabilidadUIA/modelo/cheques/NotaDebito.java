package uia.com.api.ContabilidadUIA.modelo.cheques;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;

public class NotaDebito extends InfoUIA
{
		String fecha = "";
		
		public NotaDebito()
		{			
		}
		
	    public NotaDebito(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("estado")String status, @JsonProperty("fecha")String fecha) 
		{
			super(id, name);
			this.setEstado(status);
	        super.type =  this. getClass(). getSimpleName();			
			this.setFecha(fecha);
		}
		
		
	    public NotaDebito(int id, String name, String p1) 
		{
	        super(id, name);
	        this.fecha = p1;
	    }

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}	
		
		public void validaCobranza()
		{
					System.out.println("Ejecutando validaCobranza() de  " + this.getId()+ "  "+this.getName());
		}
	
}