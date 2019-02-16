package errores;

public class Error {
	
	private final TipoError tipo;
	private String mensaje;
	private int columna;
	private int fila;
	
	public Error(TipoError _tipo, String _mensaje, int _fila, int _columna) {
		tipo = _tipo;
		mensaje = _mensaje;
		fila = _fila;
		columna = _columna;
	}
	public Error(TipoError _tipo, String _mensaje) {
		tipo = _tipo;
		mensaje = _mensaje;
		fila = -1;
		columna = -1;
	}
	
	public enum TipoError{
		LEXICO,
		SINTACTICO,
		SEMANTICO
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	public TipoError getTipo() {
		return tipo;
	}

}
