import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class FormCadastroCliente extends JFrame {

	private JPanel contentPane;	
	public JTextField textNome;
	public JTextField textEmail;
	public JTextField textTelefone;
	public JTextField textCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastroCliente frame = new FormCadastroCliente();
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
	public FormCadastroCliente() {
		setTitle("Cadastro de Clientes - Tudo de Bom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 116, 114, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 181, 59, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 151, 45, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(221, 151, 77, 19);
		contentPane.add(lblNewLabel_3);
		
		textNome = new JTextField();
		textNome.setBounds(117, 117, 295, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(85, 181, 327, 25);
		contentPane.add(textEmail);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(279, 149, 133, 25);
		contentPane.add(textTelefone);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(42, 149, 169, 25);
		contentPane.add(textCpf);
		
		// cadastra os clientes 
		
		final Clientes cliente = new Clientes();
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrarCliente.setBounds(44, 219, 146, 31);
		
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.conectar();
				String nome = textNome.getText();
				String email = textEmail.getText();
				String telefone = textTelefone.getText();
				String cpf = textCpf.getText();
				
				if(nome.equals("") || email.equals("") || telefone.equals("") || cpf.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados.");							
				} else {
					cliente.cadastrarCliente(nome, email, telefone, cpf);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");	
				}			
										
			}
		});
		contentPane.add(btnCadastrarCliente);
		
		// limpa todos os dados
		
		JButton btnLimparDados = new JButton("Limpar dados");
		btnLimparDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimparDados.setBounds(235, 219, 146, 31);
		
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText(""); 
				textTelefone.setText("");
				textEmail.setText("");
				textCpf.setText("");
			}
		});
		
		contentPane.add(btnLimparDados);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FormCadastroCliente.class.getResource("/ViewImagens/PlanoFuntoTelaUpdate.jpg")));
		lblNewLabel_4.setBounds(-11, 0, 455, 271);
		contentPane.add(lblNewLabel_4);
	}
}