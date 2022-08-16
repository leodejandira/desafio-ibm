import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormDeletarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textDelete;
	private JTextField textConfirma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDeletarCliente frame = new FormDeletarCliente();
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
	public FormDeletarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel texteIdsa = new JLabel("ID");
		texteIdsa.setFont(new Font("Tahoma", Font.BOLD, 12));
		texteIdsa.setBounds(145, 139, 21, 14);
		contentPane.add(texteIdsa);
		
		textDelete = new JTextField();
		textDelete.setBounds(198, 137, 86, 20);
		contentPane.add(textDelete);
		textDelete.setColumns(10);
		
		textConfirma = new JTextField();
		textConfirma.setBounds(198, 168, 86, 20);
		contentPane.add(textConfirma);
		textConfirma.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite CONFIRMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(82, 170, 105, 14);
		contentPane.add(lblNewLabel);
		
		JButton bntDeletarCliente = new JButton("Deletar");
		bntDeletarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes bd = new Clientes();
				bd.conectar(); 
				String id = textDelete.getText();
				String confirma = textConfirma.getText();
				if(bd.estaConectado()) {
					if(id.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados.");
						
					}else if(confirma.equals("CONFIRMA")) {
						bd.deletarclientes(id, confirma);
						JOptionPane.showMessageDialog(null, "Cliente deletado.");
					}
					}
						
					}
		});
		bntDeletarCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		bntDeletarCliente.setBounds(195, 216, 89, 23);
		contentPane.add(bntDeletarCliente);
	}
}
