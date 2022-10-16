package service;

import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Aluno;
import model.Pessoa;
import model.PessoaF;
import repository.Repository;
import util.corrige;

public class AlunoService {

	Scanner teclado;;
	Service ser;
	Repository<Aluno> repository = new Repository();
	
	public AlunoService(Scanner teclado) {
		this.teclado = teclado;
	}
	
	
	public Pessoa criarAluno(String nome, String lastname, String email, String telefone, String nascimento, double notaF, String inscricaoS, String dataA) {
		if(dataA == null) {
			dataA = "Cadastro ainda não atualizado.";
		}
		Aluno aluno = new Aluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
		repository.salvar(aluno);
		return aluno;
	}
	
	public Pessoa atualizarAluno(String nome, String lastname, String email, String telefone, String nascimento, double notaF, String inscricaoS, String dataA) {
		Aluno aluno = new Aluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
		repository.salvar(aluno);
		return aluno;
	}
	
	public String confereEmail(String email, List cadastradosA) {
		
		cadastradosA = this.repository.buscarTodos();
		
		return cadastradosA.toString();
				
	
	}
	
	public void mostrarTodosCadastrados() {
			
		List<Aluno> alunos = this.repository.buscarTodos();
		
		for(Aluno aluno : alunos) {
				
			System.out.println(aluno);
					
		}
		
	}
}
