package uia.com.api.ContabilidadUIA.modelo.gestor;

public class DecoradorCheques extends Decorador {
	
	public DecoradorCheques(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorCheques()
	{		
	}
	
	public void validaCheques()
	{
		super.Print();
	}


}
