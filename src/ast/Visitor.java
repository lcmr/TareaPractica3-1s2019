package ast;

/**
 * @author luis
 * Esta interfaz se encarga de visitar cada una de las clases
 */
public interface Visitor{
	Object visit(Primitivo primitivo);
	Object visit(Aritmetica aritmetica);
	Object visit(Booleana booleana);
	Object visit(Relacional relacional);
}
