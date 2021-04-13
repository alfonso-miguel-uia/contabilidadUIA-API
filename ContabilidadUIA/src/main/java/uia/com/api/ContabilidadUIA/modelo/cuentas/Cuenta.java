package uia.com.api.ContabilidadUIA.modelo.cuentas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;

public class Cuenta extends InfoUIA
{
		String fecha = "";
		private String nombre;
		private CharSequence tipo;
		List<InfoUIA> subCat1 = new ArrayList<InfoUIA>();
		List<InfoUIA> subCat2 = new ArrayList<InfoUIA>();
		
		boolean cXP = false;
		
		
		@JsonCreator
	    public Cuenta(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("fecha")String p1) 
		{
	        super(id, name);
	        super.type =  this. getClass(). getSimpleName();
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
		}

		public void registraCXP(String cheque, Map<String, InfoUIA> catalogo) 
		{
			if(validaCheque(cheque, catalogo))
				this.registraCheque(cheque);						
		}

		private boolean validaCheque(String nomCheque, Map<String, InfoUIA> catalogo) 
		{
			cXP=false;
			
			if(catalogo != null)
			{
				for (Map.Entry<String, InfoUIA> p : catalogo.entrySet()) 
				{					
						nombre = p.getValue().getName();
						
						if(nomCheque.contains(nombre))
						{
							subCat1 = p.getValue().getItems();							
							subCat1.forEach(q->{
								if(nomCheque.contains(q.getName()))
								{
									q.Print();
									subCat2 = q.getItems();							
									subCat2.forEach(item->{
										if(nomCheque.contains(item.getName()))
										{
											item.Print();
											item.setEstado("valido");
											cXP = true;
										}
									});									
								}
							});
						}						
				}
			}
			return cXP;
		}

		private void registraCheque(String cheque) {
			this.setEstado("Cheque :"+cheque+" registrado");
			
		}
}