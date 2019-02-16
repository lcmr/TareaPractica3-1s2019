package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.main;
import javax.swing.JLabel;;

public class MainWindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtrIntA;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JButton btnAnalizar;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Tarea Practica 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrIntA = new JTextArea();
		txtrIntA.setText("int a = 5;\nimprimir(a);\n{\na = a + 5;\nimprimir(a);\n{\nint b = a + 2;\nimprimir(b);\n}\nimprimir(b);\n}\nimprimir(a);");
		txtrIntA.setBounds(5, 33, 683, 180);
		contentPane.add(txtrIntA);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(5, 253, 683, 180);
		contentPane.add(textArea_1);
		
		btnAnalizar = new JButton("Analizar");
		btnAnalizar.setBounds(596, 633, 92, 25);
		btnAnalizar.addActionListener(this);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(5, 472, 683, 149);
		contentPane.add(textArea_2);
		contentPane.add(btnAnalizar);
		
		JLabel lblNewLabel = new JLabel("Entrada");
		lblNewLabel.setBounds(12, 6, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setBounds(15, 225, 70, 15);
		contentPane.add(lblSalida);
		
		JLabel lblErrores = new JLabel("Errores");
		lblErrores.setBounds(5, 445, 70, 15);
		contentPane.add(lblErrores);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fuente = e.getSource();
		   if (fuente==btnAnalizar)
			   System.out.println("Inicia Analisis");
			   main.interpretar(txtrIntA.getText());
	}
	
	public void setOuputText(String text) {
		textArea_1.setText(text);
	}
	
	public void setErrorText(String text) {
		textArea_2.setText(text);
	}
	
	
}
