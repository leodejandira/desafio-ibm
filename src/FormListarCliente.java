import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class FormListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListarCliente frame = new FormListarCliente();
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
	public FormListarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Telefone", "Email"
			}
		));
		table.setBounds(44, 76, 348, 151);
		contentPane.add(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 
		JButton btnNewButton = new JButton("Mostrar tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String servidor = "jdbc:mysql://localhost/ibm";		
				String usuario = "root";		
				String senha = "mysql";				
				String driver = "com.mysql.cj.jdbc.Driver";
				Connection con;
				try {
					con = DriverManager.getConnection(servidor, usuario, senha);
					Statement stmt	 = con.createStatement();
					String sql = "select * from clientes";
					ResultSet resultSet =stmt.executeQuery(sql) ;
					while(resultSet.next()) {
						//iniciando as Variáveis cliente
						VariaveisCliente c = new VariaveisCliente();
						
						//Setando as informações do MySQL para uma variável cliente
						c.setId(resultSet.getString("id_client"));
						c.setNome(resultSet.getString("nome_cliente"));
						c.setCpf(resultSet.getString("cpf_cliente")); 
						c.setTelefone(resultSet.getString("telefone_cliente"));
						c.setEmail(resultSet.getString("email_cliente")); 
				
						String tbData[]= {c.getId(),c.getNome(),c.getCpf(),c.getTelefone(),c.getEmail()};
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.addRow(tbData);	
				}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}
		});
		btnNewButton.setBounds(52, 42, 134, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Lista de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(163, 11, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormListarCliente.class.getResource("/ViewImagens/PlanoFuntoTelaUpdate.jpg")));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_1);
		
	}	
}