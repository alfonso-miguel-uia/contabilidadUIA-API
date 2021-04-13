package uia.com.api.ContabilidadUIA.modelo.cuentas;

import uia.com.api.ContabilidadUIA.modelo.cheques.Cheque;
import uia.com.api.ContabilidadUIA.modelo.cheques.GestorCheques;
import uia.com.api.ContabilidadUIA.modelo.clientes.Cliente;

public class GestorCuentas {
	
	private GestorCheques miGestorCheques = new GestorCheques();
	private Cuenta miCCheques;
	private Cliente miCliente;
	
	public void GestorCuentas()
	{}
	
	public void validaCobranza(Cliente cliente)
	{
		miCliente = cliente;
		//miCliente.validaCobranza();		
	}

	public void registraCheque(Cliente cliente, String nomCuentaCheques, String nomCheque) 
	{

		this.miCliente = cliente;
		if(this.miGestorCheques != null && miCliente != null)
		{
			for(int i = 0; i < this.miCliente.getItems().size(); i++)
			{
			    miCCheques = (Cuenta) this.miCliente.getItems().get(i);
			    if(miCCheques.getName().contains(nomCuentaCheques.toString()))
			    	break;
			}
			
			if(miCCheques != null)
				miGestorCheques.registraCheque(miCCheques,  nomCuentaCheques, nomCheque);
			else
				System.out.println("Error: Cuenta de cheques no encontrada");
		}
	}
	
	

}
