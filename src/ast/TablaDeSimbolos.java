package ast;

import java.util.LinkedList;

public class TablaDeSimbolos extends LinkedList<Simbolo> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor de la clase que lo único que hace es llamar al constructor de 
     * la clase padre, es decir, el constructor de LinkedList.
     */
    public TablaDeSimbolos() {
        super();
    }

    /**
     * Método que busca una variable en la tabla de símbolos y devuelve su valor.
     * @param id Identificador de la variable que quiere buscarse
     * @return Valor de la variable que se buscaba, si no existe se devuelve nulo
     */
    Object getValor(String id) {
        for (int i = this.size()-1; i >= 0; i--) {
            Simbolo s=this.get(i);
            if(s.isParametro() && s.isParametroInicializado() || !s.isParametro()){
                if(s.getId().equals(id)){
                    Object aux=s.getValor();
                    return aux;
                }
            }
        }
        System.err.println("La variable "+id+" no existe en este ámbito.");
        return null;
    }
    
    /**
     * Método que asigna un valor a una variable específica, si no la encuentra 
     * no realiza la asignación y despliega un mensaje de error.
     * @param id Identificador de la variable que quiere buscarse
     * @param valor Valor que quiere asignársele a la variable buscada
     */
    void setValor(String id, Object valor) {
        for (int i = this.size()-1; i >= 0; i--) {
            Simbolo s=this.get(i);
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
    /**
     * Méotodo que marca como inicializado el último parámetro agregado con el nombre de identificador indicado.
     * @param id 
     */
    void setParametroInicializado(String id) {
        for (int i = this.size()-1; i >= 0; i--) {
            Simbolo s=this.get(i);
            if(s.getId().equals(id)){
                s.setParametroInicializado(true);
                return;
            }
        }
        System.out.println("El parámtro "+id+" que quiere marcar como inicializado no existe en este ámbito, por lo "
                + "que no puede marcar.");
    }
    
}
