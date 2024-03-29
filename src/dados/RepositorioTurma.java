package dados;

import classesBase.Turma;
import excecoes.ElementoNaoEncontradoException;


public interface RepositorioTurma {
	public void inserir (Turma turma);
	public Turma procurar(String nome) throws ElementoNaoEncontradoException;
	public void atualizar(Turma turma)throws ElementoNaoEncontradoException;
	public void remover(String nome)throws ElementoNaoEncontradoException;
	public String imprimir();
	public int getCont();

}
