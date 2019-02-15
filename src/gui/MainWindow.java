package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.main;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Tarea Practica 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(main.interpretar(textArea.getText()));
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(textField);
		textField.setColumns(10);
		contentPane.add(btnAnalizar);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Tarea 2");
			putValue(SHORT_DESCRIPTION, "Operaciones aritmeticas usando el patron de diseno Visitor");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
