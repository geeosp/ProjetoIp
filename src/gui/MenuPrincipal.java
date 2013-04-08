package gui;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import fachadaEscola.Escola;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	public static Escola fachada;
	private final ButtonGroup grupo = new ButtonGroup();
	private String tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {

		this.fachada=PaginaPrincipal.fachada;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelecioneOQue = new JLabel(
				"Selecione o que voce deseja alterar:");
		lblSelecioneOQue.setBounds(38, 72, 235, 16);
		contentPane.add(lblSelecioneOQue);
		
		JLabel lblOQueVoc = new JLabel("O que voce quer fazer?");
		lblOQueVoc.setBounds(38, 263, 156, 16);
		contentPane.add(lblOQueVoc);

		JLabel lblBemvindo = new JLabel("Bem-vindo!");
		lblBemvindo.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		lblBemvindo.setBounds(38, 37, 156, 23);
		contentPane.add(lblBemvindo);

		JRadioButton rdbtnAlunos = new JRadioButton("Alunos");
		rdbtnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo="aluno";
			}
		});
		rdbtnAlunos.setMnemonic('1');
		grupo.add(rdbtnAlunos);
		rdbtnAlunos.setBounds(35, 95, 141, 23);
		contentPane.add(rdbtnAlunos);

		JRadioButton rdbtnProfessores = new JRadioButton("Professores");
		rdbtnProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo="professor";
			}
		});
		grupo.add(rdbtnProfessores);
		rdbtnProfessores.setBounds(35, 118, 141, 23);
		contentPane.add(rdbtnProfessores);

		JRadioButton rdbtnAdministradores = new JRadioButton("Administradores");
		rdbtnAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo="administrador";
			}
		});
		grupo.add(rdbtnAdministradores);
		rdbtnAdministradores.setBounds(35, 141, 141, 23);
		contentPane.add(rdbtnAdministradores);

		JRadioButton rdbtnFuncionrios = new JRadioButton("Funcion\u00E1rios");
		rdbtnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo="funcionario";
				
			}
		});
		grupo.add(rdbtnFuncionrios);
		rdbtnFuncionrios.setBounds(35, 164, 141, 23);
		contentPane.add(rdbtnFuncionrios);

		JRadioButton rdbtnTurmas = new JRadioButton("Turmas");
		rdbtnTurmas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tipo="turma";
			}
			
		});
		grupo.add(rdbtnTurmas);
		rdbtnTurmas.setBounds(35, 187, 141, 23);
		contentPane.add(rdbtnTurmas);

		JRadioButton rdbtnDisciplinas = new JRadioButton("Disciplinas");
		rdbtnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo="disciplina";
			}
		});
		grupo.add(rdbtnDisciplinas);
		rdbtnDisciplinas.setBounds(35, 209, 141, 23);
		contentPane.add(rdbtnDisciplinas);


		

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					cadastrar();
				} catch(NullPointerException e1){
					JOptionPane.showMessageDialog(MenuPrincipal.this, "Selecione uma opcao");
				}
			}

			private void cadastrar() {
				
				if (tipo.equals("aluno")){
					CadastrarAlunoFrame frame = new CadastrarAlunoFrame();
					frame.setVisible(true);
					setVisible(false);
				} else if (tipo.equals("professor")){
					CadastrarProfessorFrame frame = new CadastrarProfessorFrame();
					frame.setVisible(true);
					setVisible(false);
				} else if (tipo.equals("administrador")){
					CadastrarAdmFrame frame = new CadastrarAdmFrame();
					frame.setVisible(true);
					setVisible(false);
				} else if (tipo.equals("turma")){
					CadastrarTurmaFrame frame = new CadastrarTurmaFrame(false);
					frame.setVisible(true);
					//JOptionPane.showMessageDialog(MenuPrincipal.this,"Fa�a o frame de Cadastrar Turma");
					setVisible(false);
				} else if (tipo.equals("funcionario")){
					CadastrarFuncionarioFrame frame = new CadastrarFuncionarioFrame();
					frame.setVisible(true);
					//JOptionPane.showMessageDialog(MenuPrincipal.this,"Fa�a o frame de Cadastrar Funcionario");
					setVisible(false);
				} else if (tipo.equals("disciplina")){
					CadastrarDisciplinaFrame frame = new CadastrarDisciplinaFrame();
					frame.setVisible(true);
					//JOptionPane.showMessageDialog(MenuPrincipal.this,"Fa�a o frame de Cadastrar Disciplina");
					setVisible(false);
				} 
				
				else {
					JOptionPane.showMessageDialog(MenuPrincipal.this,"n encontrou ngm");
				}
				
			}
		});
		btnCadastrar.setBounds(38, 291, 97, 50);
		contentPane.add(btnCadastrar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcurarFrame frame = new ProcurarFrame(tipo);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnProcurar.setBounds(349, 291, 97, 50);
		contentPane.add(btnProcurar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(142, 291, 97, 50);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnRemover);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setBounds(245, 291, 97, 50);
		contentPane.add(btnAtualizar);
		
		JButton btnRelatrio = new JButton("Relatorio");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  //RELATORIO
				
				RelatorioFrame frame = new RelatorioFrame(tipo);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnRelatrio.setBounds(452, 291, 97, 50);
		contentPane.add(btnRelatrio);

	}
}
