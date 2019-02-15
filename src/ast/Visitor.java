package ast;

/**
 * @author luis
 * Esta interfaz se encarga de visitar cada una de las clases
 */
public interface Visitor{
	Object visit(Primitivo primitivo, TablaDeSimbolos tabla);
	Object visit(Aritmetica aritmetica, TablaDeSimbolos tabla);
	Object visit(Booleana booleana, TablaDeSimbolos tabla);
	Object visit(Relacional relacional, TablaDeSimbolos tabla);
	Object visit(Arbol arbol, TablaDeSimbolos tabla);
	Object visit(Declaracion declaracion, TablaDeSimbolos tabla);
	Object visit(Asignacion asignacion, TablaDeSimbolos tabla);
	Object visit(Imprimir imprimir, TablaDeSimbolos tabla);
}
