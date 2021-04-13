package uia.com.api.ContabilidadUIA.modelo.clientes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public  class ListaInfoUIA 
{
	protected int id;
	protected String name;
	
	 private List<InfoUIA> items;

	    public ListaInfoUIA(List<InfoUIA> pl) {
	        this.items = pl;
	    }

	    public ListaInfoUIA() {
	        this.items = new ArrayList<InfoUIA>();
	    }

	    public List<InfoUIA> getItems() {
	        return this.items;
	    }

	    public void setItems(List<InfoUIA> l) {
	        this.items = l;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void agregaCatalogo(InfoUIA newCatalogo) {
			if(this.items != null)
				this.items.add(newCatalogo);		
		}
	    
}
