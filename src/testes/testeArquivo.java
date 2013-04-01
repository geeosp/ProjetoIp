package testes;



import classesBase.Aluno;
import classesBase.Endereco;
import classesBase.Pessoa;
import classesBase.Professor;
import classesBase.Turma;
import dados.RepositorioPessoaArquivoXls;
import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

public class testeArquivo {

	public static void main(String[] args) {
		
		System.out.println("comecou");

		RepositorioPessoaArquivoXls pessoas = new RepositorioPessoaArquivoXls();

		Endereco end = new Endereco("sddsad", "sdasd", "Sadasd", "sdsad",
				"asd", "", "asdasd");
		Turma turma = new Turma("tumrma1");

		Pessoa bruna = new Aluno("43536787656", "Bruna", "7727724", "F", end,
				"Luiz", "Nancy", turma);
		// Pessoa harry = new Aluno("25365576866", "Harry", "7727724", "F", end,
		// "Luiz", "Nancy", turma);
		Pessoa laryssa = new Professor("47623456456", "Laryssa", "7727724",
				"F", end, "ser legal", "alasdsas");
		Pessoa geba = new Aluno("83830480504", "Geovane", "7727724", "F", end,
				"Luiz", "Nancy", turma);

		Pessoa novo = new Aluno("000000", "Fulano", "7727724", "F", end,
				"Luiz", "Nancy", turma);

		Pessoa prof = new Professor("47623456456", "Prof", "7727724", "F", end,
				"ser legal", "alasds");
		
		Pessoa item = new Professor("47623456456", "profatualizado", "7727724", "F", end,
				"ser legal", "alasds");

		// Pessoa novo2 = new Aluno("000000", "Fulano2", "7727724", "F", end,
		// "Luiz", "Nancy", turma);
		
		System.out.println("imprimindo: ");
		System.out.println(pessoas.getPessoas().imprimir());

		try {
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
		} catch (RepositorioException e) {
			System.out.println("n deu certo");
		}
		
		System.out.println("imprimindo inseriu: ");
		System.out.println(pessoas.getPessoas().imprimir());
		
		try {
			pessoas.remover("33");
			//pessoas.atualizar(item);
			//System.out.println(pessoas.procurar("83830480504").getNome());
			System.out.println(pessoas.getPessoas().procurar("83830480504").getNome()+" <<<<\n");
		} catch (RepositorioException e) {
			System.out.println("rep excep");
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("n encontrado");
		}
		
		System.out.println("imprimindo removeu bruna: ");
		System.out.println(pessoas.getPessoas().imprimir());
	}

}
