package service;

import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Aluno;
import model.Pessoa;
import model.PessoaF;
import repository.Repository;
import util.corrige;

public class PessoaService {

	Scanner teclado;
	Repository<PessoaF> repository = new Repository();
	Service ser;
	
	public PessoaService(Scanner teclado) {
		this.teclado = teclado;
	}
	
	public Pessoa criarPessoaF(String nome, String lastname, String email, String telefone, String nascimento, String inscricaoS, String dataA) {
		if(dataA == null) {
			dataA = "Cadastro ainda não atualizado.";
		}
		PessoaF pessoaF = new PessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
		repository.salvar(pessoaF);
		return pessoaF;
	}
	
	public Pessoa atualizarPessoaF(String nome, String lastname, String email, String telefone, String nascimento, String inscricaoS, String dataA) {
		PessoaF pessoaF = new PessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
		repository.salvar(pessoaF);
		return pessoaF;
	}
	
	public String confereEmail(String email, List cadastradosP) {
		
		cadastradosP = this.repository.buscarTodos();
		
		return cadastradosP.toString();
				
	}
	
	public void mostrarTodosCadastrados() {
		
		List<PessoaF> pessoas = this.repository.buscarTodos();
		
		for(PessoaF pessoaF : pessoas) {
					
			System.out.println(pessoaF);
					
		}
		
	}
	
	
}
