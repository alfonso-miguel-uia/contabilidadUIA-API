package uia.com.api.ContabilidadUIA.modelo.gestor;

import java.util.Map;

import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;
import uia.com.api.ContabilidadUIA.modelo.clientes.ListaInfoUIA;

public class Gestor extends AGestor{

	
	public Gestor(String nomFile) {
		super(nomFile);
		// TODO Auto-generated constructor stub
	}


	public void Gestor()
	{	
	}
	
	
	@Override
	public void Print() {
		super.Print();		
	}

	@Override
	public void Lee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Busca() {
		
		
	}


	@Override
	public IGestor getGestor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setGestor(IGestor p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Map<String, InfoUIA> getCatalogoMaestro() {
		return super.getCatalogoMaestro();
	}


	@Override
	public InfoUIA agregaCatalogo(InfoUIA p) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListaInfoUIA getListaInfoUIA() {
		return super.getMiLista();
	}

}
