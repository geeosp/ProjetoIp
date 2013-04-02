package testes;

import java.util.Iterator;

import classesBase.*;
import modificacoes.*;
import excecoes.*;

public class TesteGeba3Lista {
	public static void main(String[] args) {

		RepositorioListaPessoa2 pessoas = new RepositorioListaPessoa2();
		Endereco end = new Endereco("sddsad", "sdasd", "Sadasd", "sdsad",
				"asd", "", "asdasd");
		Turma turma = new Turma("tumrma1");
		Pessoa bruna = new Aluno("43536787656", "Bruna","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);
		Pessoa harry = new Aluno("25365576866", "Harry","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);
		Pessoa alana = new Aluno("47623456456", "Laryssa","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);
		Pessoa geba = new Aluno("83830480504", "Geovane","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);

		Pessoa novo = new Aluno("000000", "Fulano","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);

		Pessoa novo2 = new Aluno("000000", "Fulano2","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);

		Pessoa timmy = new Aluno("123456789", "Timmy Turner","", "34655843", "F",
				"",end, "Pai", "Mae", turma);

		pessoas.inserir(geba);
		pessoas.inserir(harry);
		pessoas.inserir(bruna);
		pessoas.inserir(novo);
		pessoas.inserir(alana);

		System.out.println("\nImprima:\n");

		System.out.println("\n\n" + pessoas.imprimir());

		System.out.println("\nProcurando geba:o primeiro da lista\n");
		try {
			System.out.println(pessoas.procurar("83830480504").getNome());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("N�o achei");
		}

		System.out.println("\nProcurando Alana:a ultima da lista\n");
		try {
			System.out.println(pessoas.procurar("47623456456").getNome());
		} catch (ElementoNaoEncontradoException e1) {
			System.out.println("N�o achei");
		}

		System.out.println("\nProcurando Harry:l� no meioda lista\n");
		try {
			System.out.println(pessoas.procurar("25365576866").getNome());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("N�o achei");
		}

		System.out.println("\n\nTeste aualizar Fulano p Fulano2\n");
		try {
			pessoas.atualizar(novo2);
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("N�o achei");
		}
		pessoas.imprimir();

		Pessoa alana2 = new Aluno("47623456456", "Alana", "","7727724", "F","", end,
				"Luiz", "Nancy", turma);
		Pessoa geba2 = new Aluno("83830480504", "Geba","", "7727724", "F","", end,
				"Luiz", "Nancy", turma);
		System.out.println("\n\nTeste aualizar Laryssa p Alana\n");
		try {
			pessoas.atualizar(alana2);
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("N�o achei");
		}
		pessoas.imprimir();

		System.out.println("\n\nTeste aualizar Geovane p Geba\n");
		try {
			pessoas.atualizar(geba2);
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("N�o achei");
		}
		System.out.println("\n\n" + pessoas.imprimir());

		System.out.println("Apagando alana");
		try {
			pessoas.remover("47623456456");
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}
		System.out.println("\n\n" + pessoas.imprimir());

		System.out.println("apagando Harry");
		try {
			pessoas.remover("25365576866");
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}
		System.out.println(pessoas.imprimir());

		System.out.println("Apagaremos geba");
		try {
			pessoas.remover("83830480504");
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}

		System.out.println("\n\n" + pessoas.imprimir());

		System.out.println("Inserindo todo mundo");
		pessoas.inserir(geba);
		pessoas.inserir(harry);
		pessoas.inserir(bruna);
		pessoas.inserir(novo);
		pessoas.inserir(alana);
		pessoas.inserir(timmy);
		System.out.println(pessoas.imprimir());

		System.out.println("procurando Ful");
		try {
			RepositorioArrayPessoa2 resultado = pessoas.procurarNome("Ful");
			System.out.println(resultado.imprimir());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}

		System.out.println("procurando immy");
		try {
			RepositorioArrayPessoa2 resultado = pessoas.procurarNome("immy");
			System.out.println(resultado.imprimir());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}

		System.out.println("procurando Turner");
		try {
			RepositorioArrayPessoa2 resultado = pessoas.procurarNome("Turner");
			System.out.println(resultado.imprimir());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}

		System.out.println("procurando turner");
		try {
			RepositorioArrayPessoa2 resultado = pessoas.procurarNome("turner");
			System.out.println(resultado.imprimir());
		} catch (ElementoNaoEncontradoException e) {
			System.out.println("Nao achei");
		}
		/**
		 * Iterator<Pessoa> it = pessoas.iterator(); while (it.hasNext()){
		 * System.out.println(it.next().getNome()); }
		 */

		// use este para RepositorioListaPessoa2
		System.out.println("Testando o iterator Lista");
		Iterator<RepositorioListaPessoa2> it = pessoas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getPessoa().getNome());
		}
		System.out.println("Fadaas!");

	}
}
