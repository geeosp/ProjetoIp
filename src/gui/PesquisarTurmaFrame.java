package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import classesBase.*;

import dados.Repositorio;
import dados.RepositorioArrayTurma;
import excecoes.ElementoNaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PesquisarTurmaFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox<Turma> comboBox;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarTurmaFrame frame = new PesquisarTurmaFrame();
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
	public PesquisarTurmaFrame() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(40, 114, 462, 235);
		contentPane.add(textArea);

		comboBox = new JComboBox<Turma>();
		comboBox.removeAllItems();
		Iterator<Turma> it = PaginaPrincipal.fachada.getTurmas().getIterator();
		while(it.hasNext()){
			comboBox.addItem(it.next());
		}
		if (comboBox.getSelectedItem() != null) {
			textArea.setText(((Turma) comboBox.getSelectedItem())
					.resumo());
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != null) {
					textArea.setText(((Turma) comboBox.getSelectedItem())
							.resumo());
				}
			}
		});

		comboBox.setBounds(40, 76, 462, 27);
		contentPane.add(comboBox);
		
						
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				setVisible(false);

			}
		});
		btnVoltar.setBounds(463, 360, 117, 50);
		contentPane.add(btnVoltar);

		JLabel lblSelecioneOTurma = new JLabel(
				"Selecione o Turma a ser editado:");
		lblSelecioneOTurma.setBounds(40, 30, 254, 16);
		contentPane.add(lblSelecioneOTurma);

		textField = new JTextField();
		textField.setBounds(40, 50, 321, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAll();
				String procura = textField.getText();
				RepositorioArrayTurma resultadoPesquisa = new RepositorioArrayTurma();
				try {
					resultadoPesquisa =PaginaPrincipal.fachada.getArrayTurma().procurarNome(procura);
				} catch (ElementoNaoEncontradoException e1) {
					String aviso = "A pesquisa n�o retornou resultados";
					JOptionPane.showInputDialog(this, aviso);
				}
				comboBox.removeAllItems();
				Iterator<Turma> it = resultadoPesquisa.iterator();
				while (it.hasNext()) {
					Turma turma = it.next();
					comboBox.addItem(turma);
				}
			}
		});
		btnPesquisar.setBounds(377, 50, 125, 23);
		contentPane.add(btnPesquisar);

	}

}