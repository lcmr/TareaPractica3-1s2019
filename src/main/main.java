/**
 * 
 */
package main;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.StringReader;

import gui.MainWindow;
import ast.*;
import errores.Error;
import errores.ListaErrores;
import errores.Error.TipoError;

/**
 * @author luis
 *
 */
public class main {
	static MainWindow frame;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public static void interpretar(String text) {
        analizadores.parser pars;
        ListaErrores.newList();
        Visitor visitor = new VisitorImplement();
        Nodo Raiz;
        
        try {
            pars=new analizadores.parser(new analizadores.Lexico(new BufferedReader(new StringReader(text))));
            pars.parse();       
            Raiz = pars.getAST();
            //Se crea una tabla de símbolos global para ejecutar las instrucciones.
            TablaDeSimbolos tabla=new TablaDeSimbolos();
            Object val = Raiz.accept(visitor, tabla);
            if(val != null) {
            	frame.setOuputText(String.valueOf(val));
            }
            frame.setErrorText(ListaErrores.getErrors());
        } catch (Exception ex) {
            ListaErrores.lista.add(new Error(TipoError.SEMANTICO, "Error fatal en compilación de entrada. \n"+ ex));
        	frame.setErrorText(ListaErrores.getErrors());
        } 
    }

}
