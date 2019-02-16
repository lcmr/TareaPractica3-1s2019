package errores;

import java.util.LinkedList;

public class ListaErrores{

	public static LinkedList<Error> lista = new LinkedList<Error>();
	
	
    public ListaErrores() {
    	newList();
    }


	public LinkedList<Error> getLista() {
		return lista;
	}

	public static void newList() {
		ListaErrores.lista = new LinkedList<Error>();
	}

	public static void addError(Error e) {
		ListaErrores.lista.add(e);
	}
	
	public static String getErrors() {
		String display = "";
		for (Error error : lista) {
			display += "Tipo: "+error.getTipo().toString().toLowerCase()+" | Mensaje: "+error.getMensaje();
			if(error.getFila()>=0) {
				display += "| Fila: "+error.getFila();
			}
			if(error.getColumna()>=0) {
				display += "| Columna: "+error.getColumna();
			}
			display += "\n";
		}
		return display;
	}
}
