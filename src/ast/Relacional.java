package ast;

/**
 * @author luis
 * Clase Suma, que visita el VisitorImplement y devuelve la suma de sus operadores
 */
public class Relacional extends Expresion{
	
	public Relacional(Nodo _izq, Nodo _der, TipoOperacion _tipo) {
		super(_izq, _der, _tipo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object accept(Visitor v, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return v.visit(this, tabla);
	}
}
