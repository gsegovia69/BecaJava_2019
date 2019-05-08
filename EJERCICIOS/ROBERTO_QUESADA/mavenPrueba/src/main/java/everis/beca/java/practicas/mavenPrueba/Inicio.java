package everis.beca.java.practicas.mavenPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Aplicación Chupiguay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(94, 88, 258, 32);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Conexion Base de Datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(94, 170, 258, 32);
		contentPane.add(button);
		
		JButton btnExplotarLaLuna = new JButton("Explotar la luna");
		btnExplotarLaLuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExplotarLaLuna.setBounds(94, 240, 258, 32);
		contentPane.add(btnExplotarLaLuna);
		
		JButton btnSalirDeLa = new JButton("Salir de la aplicación");
		btnSalirDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnSalirDeLa.setForeground(Color.RED);
		btnSalirDeLa.setBounds(94, 527, 258, 32);
		contentPane.add(btnSalirDeLa);
	}
}
