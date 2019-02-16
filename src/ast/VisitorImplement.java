package ast;

import errores.Error.TipoError;
import errores.Error;
import errores.ListaErrores;

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
	public Object visit(Primitivo primitivo, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return primitivo.getValor(tabla);
	}

	@Override
	public Object visit(Aritmetica aritmetica, TablaDeSimbolos tabla) {
		
		Object izq = (aritmetica.get_izq() == null)? null : aritmetica.get_izq().accept(this, tabla);
		Object der = (aritmetica.get_der() == null)? null : aritmetica.get_der().accept(this, tabla);
        
		switch (aritmetica.get_tipo()) {
		case RESTA:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq - (Double)der;	
			}else {
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error de tipos, la resta debe hacerse entre números."));
                System.err.println("Error de tipos, la resta debe hacerse entre números.");
				return null;
			}
		case SUMA:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq + (Double)der;	
			}else {
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error de tipos, la suma debe hacerse entre números."));
                System.err.println("Error de tipos, la suma debe hacerse entre números.");
				return null;
			}	
		case MULTIPLICACION:
			if( izq instanceof Double && der instanceof Double ) {
				return (Double)izq * (Double)der;
			}else {
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error de tipos, la multiplicación debe hacerse entre números."));
                System.err.println("Error de tipos, la multiplicación debe hacerse entre números.");
				return null;
			}
		case DIVISION:
			if( izq instanceof Double && der instanceof Double ) {
				if( (Double) der != 0 ) {
					return (Double)izq / (Double)der;	
				}else {
	                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error division entre 0, la division debe hacerse con numero diferente de cero en el divisor."));
                    System.err.println("Error division entre 0, la division debe hacerse con numero diferente de cero en el divisor.");
					return null;
				}
			}else {
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error de tipos, la división debe hacerse entre números."));
                System.err.println("Error de tipos, la división debe hacerse entre números.");
				return null;
			}
		case NEGATIVO:
			if( izq instanceof Double) {
				return - (Double)izq;	
			}else {
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO,"Error de tipos, el operador negativo debe aplicarse a un número."));
                System.err.println("Error de tipos, el operador negativo debe aplicarse a un número.");
				return null;
			}
		default:
			return null;
		}
		
	}

	@Override
	public Object visit(Booleana booleano, TablaDeSimbolos tabla) {

		Object izq = (booleano.get_izq() == null)? null : booleano.get_izq().accept(this, tabla);
		Object der = (booleano.get_der() == null)? null : booleano.get_der().accept(this, tabla);
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
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO, "Error de tipos, la operación and debe hacerse entre expresiones booleanas."));
                System.err.println("Error de tipos, la operación and debe hacerse entre expresiones booleanas.");
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object visit(Relacional relacional, TablaDeSimbolos tabla) {
		Object izq = (relacional.get_izq() == null)? null : relacional.get_izq().accept(this, tabla);
		Object der = (relacional.get_der() == null)? null : relacional.get_der().accept(this, tabla);
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
                ListaErrores.lista.add(new Error(TipoError.SEMANTICO, "Error de tipos, la comparación igual que debe hacerse entre números."));
                System.err.println("Error de tipos, la comparación igual que debe hacerse entre números.");
                return null;
            }
		default:
			return null;
		}
	}

	@Override
	public Object visit(Arbol arbol, TablaDeSimbolos tabla) {
		arbol.tablaGlobal = tabla;
		
		
        for(Nodo nodo:arbol.getNodos()){
            if(nodo instanceof Declaracion){
                Declaracion d=(Declaracion)nodo;
                d.accept(this, tabla);
            }if(nodo instanceof Asignacion){
                Asignacion d=(Asignacion)nodo;
                d.tablaPadre = tabla;
                d.accept(this, tabla);
            }if(nodo instanceof Imprimir){
                Imprimir d=(Imprimir)nodo;
                Object val = d.accept(this, tabla); 
                if(val != null) {
                    arbol.valor += "\n" + String.valueOf(val);	
                }
            }if(nodo instanceof Arbol){
                Arbol d=(Arbol)nodo;
                TablaDeSimbolos tablaLocal=new TablaDeSimbolos(); // Creamos una nueva tabla local para la función.
                tablaLocal.addAll(arbol.tablaGlobal); // Agregamos a la tabla local las referencias a las variables globales.
                Object val = d.accept(this, tablaLocal);
                if(val != null) {
                    arbol.valor += "\n" + String.valueOf(val);	
                }
            }
        }
		
		return arbol.valor;
	}

	@Override
	public Object visit(Declaracion declaracion, TablaDeSimbolos tabla) {
		if(tabla.getVariable(declaracion.id) == null) {
	        Simbolo aux=new Simbolo(declaracion.id,declaracion.tipo);
	        aux.setParametro(declaracion.parametro);
	        if(declaracion.valor.accept(this,tabla) != null) {
	            aux.setValor(declaracion.valor.accept(this,tabla));	
	        }
	        tabla.add(aux);
		}else {
	        ListaErrores.lista.add(new Error(TipoError.SEMANTICO, "La variable "+declaracion.id+" ya existe en este ambito."));
	        System.err.println("La variable "+declaracion.id+" ya existe en este ambito.");
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Asignacion asignacion, TablaDeSimbolos tabla) {
        if(tabla.getVariable(asignacion.id) != null) {
            if(asignacion.tablaPadre != null) // Si se definió una tabla padre, se obtendrá de ahí el valor a asignar.
                tabla.setValor(asignacion.id,asignacion.valor.accept(this,asignacion.tablaPadre));
            else 
                tabla.setValor(asignacion.id,asignacion.valor.accept(this,tabla));	
        }else {
	        ListaErrores.lista.add(new Error(TipoError.SEMANTICO, "La variable "+asignacion.id+" no existe en este ambito."));
	        System.err.println("La variable "+asignacion.id+" no existe en este ambito.");
        }
        // TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Imprimir imprimir, TablaDeSimbolos tabla) {
		// TODO Auto-generated method stub
		return imprimir.valor.accept(this, tabla);
	}
	
}
