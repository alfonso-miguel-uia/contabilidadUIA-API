package uia.com.api.ContabilidadUIA.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import uia.com.api.ContabilidadUIA.modelo.proveedores.*;
import uia.com.api.ContabilidadUIA.modelo.clientes.InfoUIA;
import uia.com.api.ContabilidadUIA.modelo.gestor.*;


public class ClientesRepositorio {
		
		public DecoradorProveedores gestorProveedores = null;		
		public Proveedor proveedor = null;
		public String clienteId="";
		private Gestor contabilidad;
		private ArrayList<InfoUIA> listaProveedores;

		public ClientesRepositorio()
		{
			 contabilidad = new Gestor("C:\\TSU-UIA\\2021-P\\Examen3\\ContabilidadUIA\\ListaProveedores.json");		
			 gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");		 
			 gestorProveedores.Print();
			 listaProveedores = gestorProveedores.getLista();
		}
		
		
		
		public DecoradorProveedores getGestorProveedores() {
			return gestorProveedores;
		}

		public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
			this.gestorProveedores = gestorProveedores;
		}

		public Proveedor getProveedor() {
			return proveedor;
		}

		public InfoUIA agregaCatalogo(InfoUIA newCliente)   
		{			
			return gestorProveedores.agregaCatalogo(newCliente);			
		}

		public String getClienteId() {
			return clienteId;
		}

		public void setClienteId(String clienteId) {
			this.clienteId = clienteId;
		}

		public Gestor getContabilidad() {
			return contabilidad;
		}

		public void setContabilidad(Gestor contabilidad) {
			this.contabilidad = contabilidad;
		}

		public ArrayList<InfoUIA> getListaProveedores() {
			return listaProveedores;
		}

		public void setListaProveedores(ArrayList<InfoUIA> listaProveedores) {
			this.listaProveedores = listaProveedores;
		}


 
		public Object getProveedor(String clienteId) 
		{
			proveedor = (Proveedor) contabilidad.busca(clienteId);
			return proveedor;
		}



		public Object setProveedor(String newCliente) {
			// TODO Auto-generated method stub
			return null;
		}


}
