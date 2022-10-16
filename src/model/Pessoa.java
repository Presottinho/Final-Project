package model;

import java.util.Date;

import util.Counter;

public abstract class Pessoa implements Banco{
	
	private Integer id;
	private String nome;
	private String lastname;
	private String email;
	private String nascimento;
	private String telefone;
	private double notaF;
	private String inscricaoS;
	private String dataA;
	
	public Pessoa(String nome, String lastname, String email, String telefone, String nascimento, String inscricaoS, String dataA) {
		this.id = Counter.proximoId();
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.inscricaoS = inscricaoS;
	}
	
	public Pessoa(String nome, String lastname, String email, String telefone, String nascimento, double notaF, String inscricaoS, String dataA) {
		this.id = Counter.proximoId();
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.notaF = notaF;
		this.inscricaoS = inscricaoS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClas() {
		return id;
	}

	public void setClas(Integer clas) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getNotaF() {
		return notaF;
	}

	public void setNotaF(int notaF) {
		this.notaF = notaF;
	}

	public String getInscricaoS() {
		return inscricaoS;
	}

	public void setInscricaoS(String inscricaoS) {
		this.inscricaoS = inscricaoS;
	}

	public String getDataA() {
		
		return dataA;
	}

	public void setDataA(String dataA) {
		this.dataA = dataA;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setNotaF(double notaF) {
		this.notaF = notaF;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", Email: " + this.email + "Classificação: Pessoa" + ", Número de Telefone: " + this.telefone + ", Data de nascimento: " + this.nascimento + ", Nota Final do Curso: " + this.notaF + ", Cadastro Realizado em: " + this.inscricaoS;
	}
	
	
	
}
