package testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import classesBase.Pessoa;
import dados.IteratorArray;
import dados.Repositorio;
import dados.RepositorioArrayPessoa;
import excecoes.ElementoNaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class TesteComboBox extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private EscolaTeste escola = new EscolaTeste();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteComboBox frame = new TesteComboBox();
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
	public TesteComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox lista = new JComboBox();
		lista.setBounds(50, 93, 280, 20);
		contentPane.add(lista);

		textField = new JTextField();
		textField.setBounds(50, 11, 283, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = ((Pessoa) lista.getSelectedItem()).getCpf();
				try{
					escola.getRepositorio().remover(cpf);
				}catch(ElementoNaoEncontradoException e1 ){
					System.out.println("nao funcionou");
				}
			System.out.println(escola.getRepositorio().imprimir());
			}
		});
		btnRemover.setBounds(50, 43, 89, 23);
		contentPane.add(btnRemover);
		
		JButton button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(150, 43, 89, 23);
		contentPane.add(button);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String procura = textField.getText();
				RepositorioArrayPessoa repositorio = new RepositorioArrayPessoa();
				try {
					repositorio = escola.getRepositorio().procurarNome(procura);
				} catch (ElementoNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Iterator<Pessoa> it = repositorio.iterator();
				System.out.println(escola.getRepositorio().imprimir());
				while (it.hasNext()){
					Pessoa pessoa = it.next();
					String nome = pessoa.getNome();
					lista.addItem(pessoa);
				}
			}
		});
		btnProcurar.setBounds(241, 43, 89, 23);
		contentPane.add(btnProcurar);
	}
}