package ast;

public abstract class Expresion implements Nodo  {

    /**
     * Operador izquierdo de la operación.
     */
	private Nodo _izq;
    /**
     * Operador derecho de la operación.
     */
	private Nodo _der;
    /**
     * Tipo de operación a ejecutar.
     */
	private final TipoOperacion _tipo;

    /**
     * Valor específico si se tratara de una literal, es decir un número o una
     * cadena.
     */
    private Object _valor;
	

    /**
     * Constructor de la clase para operaciones binarias (con dos operadores),
     * estas operaciones son: SUMA, RESTA, MULTIPLICACION, DIVISION,
     * AND, IGUAL_QUE
     *
     * @param _izq Operador izquierdo de la operación
     * @param _der Opeardor derecho de la operación
     * @param tipo Tipo de la operación
     */
	public Expresion(Nodo _izq, Nodo _der, TipoOperacion _tipo) {
		this.set_izq(_izq);
		this.set_der(_der);
		this._tipo = _tipo;
	}

    /**
     * Constructor para operaciones unarias (un operador), estas operaciones
     * son: NEGATIVO
     *
     * @param _izq Único operador de la operación
     * @param tipo Tipo de operación
     */
	public Expresion(Nodo _izq,  TipoOperacion _tipo) {
		this.set_izq(_izq);
		this._tipo = _tipo;
	}
	
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     * específicamente una cadena, estas operaciones son: IDENTIFICADOR, CADENA
     *
     * @param a Cadena que representa la operación a realizar
     * @param tipo Tipo de operación
     */
    public Expresion(Object a, TipoOperacion tipo) {
        this.set_valor(a);
        this._tipo = tipo;
    }

    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     * específicamente una NUMERO, estas operaciones son: NUMERO_ENTERO,
     * NUMERO_DECIMAL
     *
     * @param a Valor de tipo Double que representa la operación a realizar.
     */
    public Expresion(Double a) {
        this._valor = a;
        this._tipo = TipoOperacion.NUMERO;
    }
	
    public Expresion() {
    	_tipo = TipoOperacion.NULL;
    }
    
	public Nodo get_izq() {
		return _izq;
	}

	public void set_izq(Nodo _izq) {
		this._izq = _izq;
	}


	public Nodo get_der() {
		return _der;
	}

	public void set_der(Nodo _der) {
		this._der = _der;
	}


	public Object get_valor() {
		return _valor;
	}

	public void set_valor(Object _valor) {
		this._valor = _valor;
	}


	public TipoOperacion get_tipo() {
		return _tipo;
	}


	public enum TipoOperacion {
		SUMA,
		RESTA,
		MULTIPLICACION,
		DIVISION,
		NEGATIVO,
		NUMERO,
		IDENTIFICADOR,
		VERDADERO,
		FALSO,
		INT,
		DOUBLE,
		AND,
		IGUAL_QUE,
		ERROR,
		NULL,
	}

}
