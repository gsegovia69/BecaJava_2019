package everis.beca.java.practicas.mavenPrueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.LoggingMXBean;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JTextField pwd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		Inicio panel2 = new Inicio();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblUsuario.setBounds(84, 81, 66, 17);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblContrasea.setBounds(84, 132, 81, 17);
		contentPane.add(lblContrasea);
		
		usuario = new JTextField();
		usuario.setBounds(212, 80, 151, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		pwd = new JTextField();
		pwd.setColumns(10);
		pwd.setBounds(212, 131, 151, 20);
		contentPane.add(pwd);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(50, 258, 390, 199);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Loggin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean comprobador;
				if(pwd.getText().isEmpty() || usuario.getText().isEmpty()) {
					comprobador = false;
				} else {
					comprobador = true;
				}
				if(comprobador == true) {
					String user= "pepe";
					String pass= "123";
					if(usuario.getText().contains(user) && pwd.getText().contains(pass)) {
						textPane.setText("Loggeado correctamente.");
						panel2.setVisible(true);
						dispose();
						
						
						}else {
						textPane.setText("USUARIO Y/O CONTRASEÑA INCORRECTOS");
					}
					
					
				} else {
					textPane.setText("TIENES QUE COMPLETAR LOS CAMPOS");
				}
			}

		});
		btnNewButton.setBounds(212, 178, 89, 28);
		contentPane.add(btnNewButton);
		
		
	}
}
