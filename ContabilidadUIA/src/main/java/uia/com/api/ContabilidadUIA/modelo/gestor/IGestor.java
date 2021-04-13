package uia.com.api.ContabilidadUIA.modelo.gestor;

import java.util.Map;

import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;
import uia.com.api.ContabilidadUIA.modelo.clientes.ListaInfoUIA;

public interface IGestor {
	
	public void Print();
	public void Lee();
	public void Busca();	
	public InfoUIA busca(String id);
	public Map<String, InfoUIA> getCatalogoMaestro();
	public ListaInfoUIA getListaInfoUIA();
	public void setCatalogo(Map<String, InfoUIA> p);
	public InfoUIA agregaCatalogo(InfoUIA p);
	public IGestor getGestor();
	public void setGestor(IGestor p);
	public void salva();
}
