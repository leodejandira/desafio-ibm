import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FormsAdicionarProduto extends JFrame {
	
	private JPanel contentPane;
	private JTextField textProduto;
	private JTextField textCategoria;
	private JTextField textValor;
	private JTextField textMarca;
	private JTextField textGenerico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormsAdicionarProduto frame = new FormsAdicionarProduto();
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
	public FormsAdicionarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textProduto = new JTextField();
		textProduto.setBounds(66, 132, 339, 20);
		contentPane.add(textProduto);
		textProduto.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(209, 158, 196, 20);
		contentPane.add(textCategoria);
		textCategoria.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(66, 189, 95, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(268, 189, 137, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 134, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 191, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(142, 160, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cod. Marca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(176, 192, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		// inserindo novos produtos	
		
		final Estoque bd = new Estoque();
		
		JButton btnSalvarNovoProduto = new JButton("Salvar");
		btnSalvarNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.conectar();
				
				//String idtexto = textID.getText();
				String produto = textProduto.getText();
				String valor = textValor.getText();
				String categoria = textCategoria.getText();
				String generico = textGenerico.getText();
				//int id = Integer.parseInt(idtexto);
				String marca = textMarca.getText();			
				
				
				if(bd.estaConectado()) {
					System.out.println("Funcionando.");
					if(produto.equals("") || valor.equals("") || categoria.equals("") || marca.equals("") || generico.equals("") ) {
						JOptionPane.showMessageDialog(null, "Por favor, insira todos os dados.");							
					} else {
						bd.cadastrarProduto(produto, valor, categoria, marca, generico);
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");	
					}	
			}
		}});
		btnSalvarNovoProduto.setBounds(176, 220, 89, 23);
		contentPane.add(btnSalvarNovoProduto);
		
		JLabel lblNewLabel_4 = new JLabel("Cadastrar novo produto");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(142, 107, 155, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Genérico");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 160, 82, 14);
		contentPane.add(lblNewLabel_5);
		
		textGenerico = new JTextField();
		textGenerico.setBounds(66, 158, 66, 20);
		contentPane.add(textGenerico);
		textGenerico.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(FormsAdicionarProduto.class.getResource("/ViewImagens/PlanoFuntoTelaUpdate.jpg")));
		lblNewLabel_6.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_6);
	}
}