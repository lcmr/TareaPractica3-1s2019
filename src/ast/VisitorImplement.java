package ast;

/**
 * @author luis
 * clase VisitorImplement, esta implementa los metodos visit definidos en nuestra interfaz Visitor
 */
public class VisitorImplement implements Visitor {


	/**
	 * @param numero	Instancia de la Clase numero
	 * 
	 * esta devuelve el valor definido.
	 */
	@Override
	public Object visit(Primitivo primitivo) {
		// TODO Auto-generated method stub
		return primitivo.getValor();
	}

	@Override
	public Object visit(Aritmetica aritmetica) {
		
		Object izq = (aritmetica.get_izq() == null)? null : aritmetica.get_izq().accept(this);
		Object der = (aritmetica.get_der() == null)? null : aritmetica.get_der().accept(this);
        
		switch (aritmetica.get_tipo()) {
		case RESTA:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq - (Double)der;	
			}else {
                System.err.println("Error de tipos, la resta debe hacerse entre números.");
				return null;
			}
		case SUMA:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq + (Double)der;	
			}else {
                System.err.println("Error de tipos, la suma debe hacerse entre números.");
				return null;
			}	
		case MULTIPLICACION:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq * (Double)der;
			}else {
                System.err.println("Error de tipos, la multiplicación debe hacerse entre números.");
				return null;
			}
		case DIVISION:
			if( izq instanceof Double && der instanceof Double ) {
				if( (Double) der != 0 ) {
					return (Double)izq / (Double)der;	
				}else {
                    System.err.println("Error division entre 0, la division debe hacerse con numero diferente de cero en el divisor.");
					return null;
				}
			}else {
                System.err.println("Error de tipos, la división debe hacerse entre números.");
				return null;
			}
		case NEGATIVO:
			if( izq instanceof Double) {
				return - (Double)izq;	
			}else {
                System.err.println("Error de tipos, el operador negativo debe aplicarse a un número.");
				return null;
			}
		default:
			return null;
		}
		
	}

	@Override
	public Object visit(Booleana booleano) {

		Object izq = (booleano.get_izq() == null)? null : booleano.get_izq().accept(this);
		Object der = (booleano.get_der() == null)? null : booleano.get_der().accept(this);
		if(izq instanceof Double){
			if( (Double)izq == 1) {
				izq = true;
			}else if((Double)izq == 0) {
				izq = false;
			}
		}
		if(der instanceof Double){
			if( (Double)der == 1) {
				der = true;
			}else if((Double)der == 0) {
				der = false;
			}
		}
		
		switch (booleano.get_tipo()) {
		case AND:
			if( izq instanceof Boolean && der instanceof Boolean ) {
				return (Boolean)izq && (Boolean)der;	
			}else {
                System.err.println("Error de tipos, la operación and debe hacerse entre expresiones booleanas.");
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object visit(Relacional relacional) {
		Object izq = (relacional.get_izq() == null)? null : relacional.get_izq().accept(this);
		Object der = (relacional.get_der() == null)? null : relacional.get_der().accept(this);
		if( izq instanceof Boolean ) {
			izq = new Double(((Boolean)izq)?1:0);
		}
		if( der instanceof Boolean ) {
			der = new Double(((Boolean)der)?1:0);
		}
		switch (relacional.get_tipo()) {
		case IGUAL_QUE:
            if (izq instanceof Double && der instanceof Double) {
                return (Boolean) (((Double) izq).doubleValue() == ((Double) der).doubleValue());
            } else {
                System.err.println("Error de tipos, la comparación igual que debe hacerse entre números.");
                return null;
            }
		default:
			return null;
		}
	}
	
}
