package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repository.Repository;

public class PessoaF extends Pessoa{
	Repository<PessoaF> repository = new Repository();
	
	private String nome;
	private String lastname;
	private String email;
	private String telefone;
	private String nascimento;
	private String inscricaoS;
	private String dataA;
	
	public PessoaF(String nome, String lastname, String email, String telefone, String nascimento, String inscricaoS, String dataA) {
		super(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
		this.nome = nome;
		this.lastname = lastname;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.inscricaoS = inscricaoS;
		this.dataA = dataA;
	}
	
	public String toString() {
		return "Nome Completo: " + this.nome + " " +  this.lastname + ", Email: " + this.email + ", Classificação: Pessoa" + ", Número de Telefone: " + this.telefone + ", Data de nascimento: " + this.nascimento + ", Cadastro Realizado em: " + this.inscricaoS + ", Cadastro Atualizado em: " + this.dataA;
	}
	

}
