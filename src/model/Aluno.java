package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repository.Repository;

public class Aluno extends Pessoa{
	 
	private Integer id;
	private String nome;
	private String lastname;
	private String email;
	private String nascimento;
	private String telefone;
	private double notaF;
	private String inscricaoS;
	private String dataA;


	public Aluno(String nome, String lastname, String email, String telefone, String nascimento,  double notaF, String inscricaoS, String dataA) {
		super(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
		this.nome = nome;
		this.lastname = lastname;
		this.email = email;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.notaF = notaF;
		this.inscricaoS = inscricaoS;
		this.dataA = dataA;
	}
	
	public String toString() {
		return "Nome Completo: " + this.nome + " " + this.lastname + ", Email: " + this.email + ", Classificação: Aluno" + ", Número de Telefone: " + this.telefone + ", Data de nascimento: " + this.nascimento + ", Nota Final do Curso: " + this.notaF + ", Cadastro Realizado em: " + this.inscricaoS + ", Cadastro Atualizado em: " + this.dataA;

	}
	
}
