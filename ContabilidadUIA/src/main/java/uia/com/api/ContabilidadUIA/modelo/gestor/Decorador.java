package uia.com.api.ContabilidadUIA.modelo.gestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;
import uia.com.api.ContabilidadUIA.modelo.clientes.ListaInfoUIA;

public class Decorador implements IGestor {

	protected IGestor gestor;
	protected Map<String, InfoUIA> catalogo = new HashMap<String, InfoUIA>();
	ArrayList <InfoUIA> lista = new ArrayList<InfoUIA>();
	protected String ancestro="";
	protected String nombre="";

	public Decorador()
	{	
		super();
	}
	
	


	

	public ArrayList<InfoUIA> getLista() 
	{
		if((lista.isEmpty()))
		{
			System.out.println(this.gestor.getClass().getSimpleName());
			
			if(this.gestor.getCatalogoMaestro() != null)
			{
				for (Map.Entry<String, InfoUIA> p : this.gestor.getCatalogoMaestro().entrySet()) 
				{					
						nombre = p.getValue().getName();
						
						p.getValue().setName(nombre);
						lista.add(p.getValue());
				}
			}
		}
		
		return lista;
	}






	public void setLista(ArrayList<InfoUIA> lista) {
		this.lista = lista;
	}






	public String getAncestro() {
		return ancestro;
	}






	public void setAncestro(String ancestro) {
		this.ancestro = ancestro;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public Map<String, InfoUIA> getCatalogo() {
		return catalogo;
	}






	public Decorador(IGestor gestorIn, String tipo)
	{	
		super();
		this.ancestro = gestorIn.getClass().getSimpleName();
		if(!(this.ancestro.contains("Gestor")))
		{
			this.gestor = gestorIn.getGestor(); 
			System.out.println("Alto");
		}
		else
			this.gestor = gestorIn; 

		System.out.println(this.ancestro);
		this.carga(tipo);			
	}
		
	public IGestor getGestor() {
		return gestor;
	}


	public void setGestor(IGestor gestor) {
		this.gestor = gestor;
	}


	private void carga(String tipo) {
		
		System.out.println(this.gestor.getClass().getSimpleName());
		
		if(this.gestor.getCatalogoMaestro() != null)
		{
			for (Map.Entry<String, InfoUIA> p : this.gestor.getCatalogoMaestro().entrySet()) 
			{					
					nombre = p.getValue().getName();
					
					if(p.getValue().getType().contains(tipo))
					{
						p.getValue().setName(nombre);
						lista.add(p.getValue());
					}
					else if(!(this.ancestro.contains("Gestor")))
					{
							carga(tipo, p.getValue().getItems(), nombre);
					}
			}
				
				
				if(!(lista.isEmpty()))
				{
					lista.forEach(q->{
						catalogo.put(q.getName(), q);
					});
				}
				
				if(this.ancestro.contentEquals("Gestor"))
				{
							catalogo = this.gestor.getCatalogoMaestro();
				}
		}
		else
			System.out.println("Alto");
	
        //this.Print();

	}
	
	
private void carga(String tipo, List<InfoUIA> subCatalogo, String nombre) 
{
	if(subCatalogo != null)
	{
				subCatalogo.forEach(p->{
					if(p.getClass().getSimpleName().contains(tipo))
					{
						if(p.getName().contains(nombre))
							p.setName(p.getName());
						else
							p.setName((nombre+"-"+p.getName()));
						lista.add(p);
					}
					else
					{
						if(p.getName().contains(nombre))
							carga(tipo, p.getItems(), p.getName());
						else
							carga(tipo, p.getItems(), (nombre+"-"+p.getName()));
					}
				});
	}
}


private void carga(String tipo, List<InfoUIA> subCatalogo, InfoUIA newCatalogo) 
{
	if(subCatalogo != null)
	{
				subCatalogo.forEach(p->{
					if(p.getClass().getSimpleName().contains(tipo))
					{
						lista.add(newCatalogo);
					}
					else
					{
						if(p.getName().contains(nombre))
							carga(tipo, p.getItems(), p.getName());
						else
							carga(tipo, p.getItems(), newCatalogo);
					}
				});
	}
}

	
	@Override
	public void Print() {
    	if (catalogo != null) {
            System.out.println("----- Catalogo -----");

            for (Map.Entry<String, InfoUIA> entry : catalogo.entrySet()) {
                System.out.println(entry.getKey() + ", Cliente : " + entry.getValue());
            }
        }	
	}

	@Override
	public void Lee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Busca() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public InfoUIA busca(String id) {
		if(catalogo.containsKey(id))
    		return catalogo.get(id);
    	else
    		return null;
	}


	@Override
	public Map<String, InfoUIA> getCatalogoMaestro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setCatalogo(Map<String, InfoUIA> p) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public InfoUIA agregaCatalogo(InfoUIA newCatalogo) 
	{
		System.out.println(this.gestor.getClass().getSimpleName());
		
		String tipo = newCatalogo.getType();
		int i=0;
		
		if(this.gestor.getCatalogoMaestro() != null)
		{
			Iterator<Entry<String, InfoUIA>> tabla = this.gestor.getCatalogoMaestro().entrySet().iterator();
			// iterating every set of entry in the HashMap. 
			while (tabla.hasNext()) 
			{
				Map.Entry<String, InfoUIA> nodo = (Map.Entry<String, InfoUIA>) tabla.next();
				if(nodo.getValue().getType().contentEquals(tipo))
				{
					this.gestor.getCatalogoMaestro().put(newCatalogo.getName(), newCatalogo);
					this.gestor.getListaInfoUIA().agregaCatalogo(newCatalogo);
					this.gestor.salva();
					this.Print();
					return newCatalogo;
				}
				else if(!(this.ancestro.contains("Gestor")))
				{
						carga(tipo, nodo.getValue().getItems(), newCatalogo);
				}
			}
		}
		else
		{
			System.out.println("Alto");	
		}
		return null;
	}






	@Override
	public void salva() {
		// TODO Auto-generated method stub
		
	}






	@Override
	public ListaInfoUIA getListaInfoUIA() {
		// TODO Auto-generated method stub
		return null;
	}
}
