package ast;

/**
 * @author luis
 * Clase Numero, que visita el VisitorImplement y devuelve su valor
 */
public class Primitivo extends Expresion {
	
	public Primitivo(Object valor, TipoOperacion tipo) {
		super(valor,tipo);
	}
	
	public Object getValor() {
		switch (this.get_tipo()) {
		case NUMERO:
			return new Double(this.get_valor().toString());
		case VERDADERO:
			return true;
		case FALSO:
			return false;
		default:
			return null;
		}
	}
	
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}

}
