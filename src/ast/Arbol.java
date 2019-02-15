package ast;

import java.util.LinkedList;

public class Arbol implements Nodo {
	public String valor = "";
    /**
     * Variable correspondiente a la instancia de la tabla de simbolos global que podrá ser accedida por cualquier función interpretada.
     */
    public TablaDeSimbolos tablaGlobal;
    /**
     * Lista de Nodos (Funciones y declaraciones de variables globales) que componen el archivo.
     */
    private final LinkedList<Nodo> nodos;

    /**
     * Constructor de la clase Arbol
     * @param a Lista de instrucciones que conforman al Arbol
     */
    public Arbol(LinkedList<Nodo> a) {
        nodos=a;
    }
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {

		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}
	public LinkedList<Nodo> getNodos() {
		return nodos;
	}

}
