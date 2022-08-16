import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FormAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textID;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAtualizarCliente frame = new FormAtualizarCliente();
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
	public FormAtualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnNewButton = new JButton("Atualizar Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes bd = new Clientes();
				bd.conectar();
				
				//String idtexto = textID.getText();
				String nome = textNome.getText();
				String email = textEmail.getText();
				String telefone = textTelefone.getText();
				String cpf = textCpf.getText();
				//int id = Integer.parseInt(idtexto);
				String id = textID.getText();
				
				
				
				if(bd.estaConectado()) {
					System.out.println("Funcionando.");
					if(nome.equals("") || email.equals("") || telefone.equals("") || cpf.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados.");							
					} else {
						bd.editarContatos(id, nome, cpf, telefone, email);
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");	
					}	
					
					System.out.print(email);
					//bd.editarContatos(4, "Lucahal", null, null, null);
					

					} else {
						System.out.println("Conecção falha");
					}
			}
		});
		btnNewButton.setBounds(148, 227, 134, 23);
		contentPane.add(btnNewButton);
		
		textNome = new JTextField();
		textNome.setBounds(66, 136, 357, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 139, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Atualizar cadastro de cliente já registrado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(88, 111, 286, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 170, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textID = new JTextField();
		textID.setBounds(66, 167, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(201, 167, 222, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(162, 170, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 201, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(66, 198, 111, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(187, 201, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textEmail = new JTextField();
		textEmail.setBounds(227, 198, 196, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(FormAtualizarCliente.class.getResource("/ViewImagens/PlanoFuntoTelaUpdate.jpg")));
		lblNewLabel_6.setBounds(0, 0, 434, 273);
		contentPane.add(lblNewLabel_6);
	}
}
