package uia.com.api.ContabilidadUIA.modelo.cheques;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;
import uia.com.api.ContabilidadUIA.modelo.clientes.ListaInfoUIA;
import uia.com.api.ContabilidadUIA.modelo.clientes.ListaNotaDebito;
import uia.com.api.ContabilidadUIA.modelo.cuentas.Cuenta;

public class Cheque extends InfoUIA
{
		String fecha = "";
		NotaDebito miNotaDebito=null;
		
		public Cheque()
		{			
		}
		
		@JsonCreator
	    public Cheque(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("estado")String status, @JsonProperty("fecha")String fecha) 
		{
			super(id, name);
			this.setEstado(status);
	        super.type =  this. getClass(). getSimpleName();			
			this.setFecha(fecha);
		}
		
		
	    public Cheque(int id, String name, String p1) 
		{
	        super(id, name);
			this.items=(List<InfoUIA>) new ListaNotaDebito();	        
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

		public void agregaNotaDebito(String nomCheque) 
		{
			ListaInfoUIA lista = null;
			
			if(this.getItems() == null)
			{
				 lista =  new ListaInfoUIA(); 
				this.setItems(lista.getItems());
			}
			int miId = this.getItems().size()+1;
			miNotaDebito = new NotaDebito(miId, "NotaDebito-"+nomCheque, "SinPagar", "14-11-2020");
			
			this.getItems().add(miNotaDebito);
			
		}
	
}