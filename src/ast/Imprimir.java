package ast;

public class Imprimir implements Nodo {

    /**
     * Valor que se le asigna a la variable.
     */
    protected final Nodo valor;
    
    public Imprimir(Nodo val) {
    	valor = val;
	}
	
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}

}
