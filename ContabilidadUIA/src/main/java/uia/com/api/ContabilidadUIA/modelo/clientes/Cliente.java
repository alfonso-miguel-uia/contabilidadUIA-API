package uia.com.api.ContabilidadUIA.modelo.clientes;


import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import uia.com.api.ContabilidadUIA.modelo.cuentas.Cuenta;



public class Cliente extends InfoUIA
{
	
		Double saldo = 0.0;
		Cuenta miCuenta = null;
		
		@JsonCreator
	    public Cliente(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("saldo")double p1) 
		{
	        super(id, name);
	        this.saldo = p1;
	    }

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public void validaCobranza() 
		{
				getItems().forEach(t->
		 				{
		 					t.validaCobranza();
			 			}
		 				);
			
		}

}

