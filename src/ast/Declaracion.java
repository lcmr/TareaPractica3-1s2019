package ast;

public class Declaracion implements Nodo {
    /**
     * Bandera que indica si lo que se declara es un parámetro o no.
     */
    protected boolean parametro;
	/**
     * Identificador de la variable que será declarada.
     */
    protected final String id;
    /**
     * Tipo de la variable que será declarada.
     */
    protected final Simbolo.Tipo tipo;
    /**
     * Valor que se le asigna a la variable.
     */
    protected final Nodo valor;
    /**
     * Constructor de la clase
     * @param a Identificador de la variable que será declarada
     * @param b Tipo de la clase que será declarada
     */
    public Declaracion(String _id, Simbolo.Tipo _tipo, Nodo _valor) {
        id=_id;
        tipo = _tipo;
        valor = _valor;
        parametro = (_valor == null)?true:false;
    }
    /**
     * Función que retorna el valor declarado
     * @return 
     */
    public String getIdentificador() {
        return id;
    }
    /**
     * Método que devuelve el valor de la bandera parámetro
     * @return 
     */
    public boolean isParametro() {
        return parametro;
    }
    /**
     * Método con el que se configura el valor de la bandera parámetro.
     * @param parametro 
     */
    public void setParametro(boolean parametro) {
        this.parametro = parametro;
    }
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}

}
