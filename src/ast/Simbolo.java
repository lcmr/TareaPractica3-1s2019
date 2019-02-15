package ast;

public class Simbolo {

    /**
     * Bandera que indica si el símbolo creado es un parámetro o no.
     */
    private boolean parametro;
    /**
     * Si el símbolo es un parámetro y además ya se le asigno valor esta bandera es verdadera, de lo contrario es falsa.
     */
    private boolean parametroInicializado;
	/**
     * Tipo del símbolo que se almacena
     */
    private final Tipo tipo;
    /**
     * Identificador del símbolo que se almacena
     */
    private final String id;
    /**
     * Variable que almacena el valor del símbolo para la operación de ejecución
     */
    private Object valor;    
    /**
     * Constructor de la clase Símbolo.
     * @param id identificador de la variable que se desea almacenar
     * @param tipo tipo de la variable que se desea almacenar
     */
    public Simbolo(String id, Tipo tipo) {
        this.tipo = tipo;
        this.id = id;
    }
    /**
     * Método que devuelve el identificador de la variable almacenada en el símbolo.
     * @return Identificador de la variable
     */
    public String getId() {
        return id;
    }
    /**
     * Método que devuelve el valor que almacena la variable.
     * @return Valor de la variable
     */
    public Object getValor() {
        return valor;
    }
    /**
     * Método que asigna un nuevo valor a la variable.
     * @param v Nuevo valor para la variable.
     */
    void setValor(Object v) {
        valor=v;
    }
    /**
     * Método que devuelve el tipo de la variable.
     * @return Tipo de la variable
     */
    public Tipo getTipo() {
		return tipo;
	}
    /**
     * Método que devuelve el valor de la bandera parámetro.
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
    /**
     * Método que devuelve el valor de la bandera parámetro inicializado.
     * @return 
     */
    public boolean isParametroInicializado() {
        return parametroInicializado;
    }
    /**
     * Método con el que se configura el valor de la bandera parámetro inicializado.
     * @param parametroInicializado
     */
    public void setParametroInicializado(boolean parametroInicializado) {
        this.parametroInicializado = parametroInicializado;
    }
    
	/**
     * Enumeración que lista todos los tipos de variable reconocidos en el lenguaje.
     */
    public static enum Tipo{
        INT,
        DOUBLE,
        CADENA,
        BOOLEANO,
        VOID
    }
}
