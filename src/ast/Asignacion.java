package ast;

public class Asignacion implements Nodo {

    /**
     * Identificador de la tabla de simbolos padre de la asignación.
     */
    protected TablaDeSimbolos tablaPadre;
    /**
     * Identificador de la variable a la que se le asigna el valor.
     */
    protected final String id;
    /**
     * Valor que se le asigna a la variable.
     */
    protected final Nodo valor;
    
    /**
     * Constructor de la clase asignación
     * @param a identificador de la variable
     * @param b valor que se le va a asignar
     */
    public Asignacion(String a, Nodo b) {
        this.id=a;
        this.valor=b;
    }
    
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}

}
