/**
 * 
 */
package main;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.StringReader;

import gui.MainWindow;
import ast.*;

/**
 * @author luis
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public static String interpretar(String text) {
        analizadores.parser pars;
        
        Visitor visitor = new VisitorImplement();
        Nodo Raiz;
        
        try {
            pars=new analizadores.parser(new analizadores.Lexico(new BufferedReader(new StringReader(text))));
            pars.parse();       
            Raiz = pars.getAST();
            return String.valueOf(Raiz.accept(visitor)) ;
            
        } catch (Exception ex) {
            return("Error fatal en compilación de entrada.");
        } 
    }

}
