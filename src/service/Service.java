package service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import exception.SistemaException;
import menu.Menu;
import model.Aluno;
import model.Pessoa;
import model.PessoaF;
import repository.Repository;
import util.corrige;
import util.dataAtual;

public class Service {

	Scanner teclado;
	Repository<Pessoa> repository = new Repository();
	AlunoService alunoService = new AlunoService(teclado);
	PessoaService pessoaService = new PessoaService(teclado);

	int notaF;
	
	public Service(Scanner teclado) {
		this.teclado = teclado;
	}
	
	public Pessoa confereEmail(String email) {
		List<PessoaF> cadastradosP = pessoaService.repository.buscarTodos();
		List<Aluno> cadastradosA = alunoService.repository.buscarTodos();
		
		for(PessoaF pessoaF : cadastradosP) {
			if(pessoaF.getEmail().equals(corrige.corrigeEmail(email))) {
				System.out.println("Cadastro já existente.");
				return pessoaF;
			}
			
		}
		for(Aluno aluno : cadastradosA) {
			if(aluno.getEmail().equals(corrige.corrigeEmail(email))) {
				System.out.println("Cadastro já existente.");
				return aluno;
			}
			
		}
		
		return cadastrar(email);
		
	}
	
	public void confereEmailAtualizacao(String email) {
			
		List<PessoaF> cadastradosP = pessoaService.repository.buscarTodos();
		List<Aluno> cadastradosA = alunoService.repository.buscarTodos();
		
		for(PessoaF pessoaF : cadastradosP) {
			if(pessoaF.getEmail().equals(corrige.corrigeEmail(email))) {
				String nome = pessoaF.getNome();
				String lastname = pessoaF.getLastname();
				String telefone = pessoaF.getTelefone();
				String nascimento = pessoaF.getNascimento();
				String inscricaoS = pessoaF.getInscricaoS();
				System.out.println("Cadastro encontrado.");
				this.atualizarDados(pessoaF, null, nome, lastname, email, telefone, nascimento, notaF, inscricaoS);
			}
			
		}
		
		for(Aluno aluno : cadastradosA) {
			if(aluno.getEmail().equals(corrige.corrigeEmail(email))) {
				String nome = aluno.getNome();
				String lastname = aluno.getLastname();
				String telefone = aluno.getTelefone();
				String nascimento = aluno.getNascimento();
				double notaF = aluno.getNotaF();
				String inscricaoS = aluno.getInscricaoS();
				System.out.println("Cadastro encontrado.");
				this.atualizarDados(null, aluno, nome, lastname, email, telefone, nascimento, notaF, inscricaoS);
			}else {
				System.out.println("Cadastro não encontrado.");
			}
			
		}
			
		}
	
	public Pessoa cadastrar(String email){
		System.out.println("========================================");
		teclado.nextLine();
		System.out.println("* - Resposta obrigatória. ");
		System.out.println("*Digite seu primeiro nome: ");
		String nome = teclado.nextLine();
		System.out.println("*Digite seu último nome: ");
		String lastname = teclado.nextLine();
		System.out.println("*Digite seu telefone: ");
		String telefone = teclado.nextLine();
		System.out.println("*Digite sua data de nascimento: ");
		String nascimento = teclado.nextLine();
		System.out.println("Digite sua nota final(0 - 10): " + "\n" + "Caso seja uma pessoa digite: 11.");
		notaF = teclado.nextInt();
		String inscricaoS = dataAtual.getDateTime().toString();
		String dataA = null;
		
		if(notaF == 11) {
			return pessoaService.criarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
		}else if(notaF < 0 || notaF > 12){
			System.out.println("Nota inválida, tente novamente.");
			return this.cadastrar(email);
		}else {
			return alunoService.criarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
		}
	}
	
	public void atualizarDados(PessoaF pessoaF, Aluno aluno, String nome, String lastname, String email, String telefone, String nascimento, double notaF, String inscricaoS) {
		int opcaoA;
		
		Menu.atualizacao();
		opcaoA = teclado.nextInt();
		
		switch(opcaoA) {
		
			case 1:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					nome = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					pessoaService.atualizarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: ");
					nome = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = aluno.getId();
					alunoService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					
		}
				break;
			case 2:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					lastname = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					pessoaService.atualizarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: ");
					lastname = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = aluno.getId();
					alunoService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
				
		}
				break;
				
			case 3:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					email = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					pessoaService.atualizarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: ");
					email = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = aluno.getId();
					alunoService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
				
		}
				break;
				
			case 4:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					telefone = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					pessoaService.atualizarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: ");
					telefone = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = aluno.getId();
					alunoService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
				
		}
				break;
			
			case 5:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					nascimento = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					pessoaService.atualizarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: ");
					nascimento = teclado.next();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = aluno.getId();
					alunoService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
				
		}
				break;
				
			case 6:
				
				if(pessoaF != null) {
					
					System.out.println("Digite o dado atualizado: ");
					notaF = teclado.nextDouble();
					String dataA = dataAtual.getDateTime().toString();
					alunoService.criarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
					int id = pessoaF.getId();
					pessoaService.repository.removerPorId(id);
					System.out.println("Dado atualizado.");
					

					
				}else if(aluno != null) {
					
					System.out.println("Digite o dado atualizado: " + "\n" + "Caso deseja retirar a nota e alterar para um cadastro de Pessoa Física digite 11. ");
					notaF = teclado.nextDouble();
					if(notaF == 11) {
						String dataA = dataAtual.getDateTime().toString();
						pessoaService.criarPessoaF(nome, lastname, email, telefone, nascimento, inscricaoS, dataA);
						int id = aluno.getId();
						alunoService.repository.removerPorId(id);
						System.out.println("Dado atualizado.");
					}else if(notaF < 0 || notaF > 11) {
						System.out.println("Nota inválida, tente novamente.");
					}else {
						String dataA = dataAtual.getDateTime().toString();
						alunoService.atualizarAluno(nome, lastname, email, telefone, nascimento, notaF, inscricaoS, dataA);
						int id = aluno.getId();
						alunoService.repository.removerPorId(id);
						System.out.println("Dado atualizado.");
					}
					break;
				
		}
		}
		
	}
	
	public void removerCadastro(String email) {
		List<PessoaF> cadastradosP = pessoaService.repository.buscarTodos();
		List<Aluno> cadastradosA = alunoService.repository.buscarTodos();
		
		String sim = "sim";
		
		for(PessoaF pessoaF : cadastradosP) {
			if(pessoaF.getEmail().equals(corrige.corrigeEmail(email))) {
				int id = pessoaF.getId();
				System.out.println("Cadastro encontrado.");
				System.out.println("Digite 'Sim' para confirmar a exclusão.(Após a confirmação essa ação não poderá ser desfeita.) ");
				String confirmacao = teclado.next();
				if(sim.equals(corrige.corrigeConfirmacao(confirmacao))) {
					pessoaService.repository.removerPorId(id);
				}
			}
			
		}
		
		for(Aluno aluno : cadastradosA) {
			if(aluno.getEmail().equals(corrige.corrigeEmail(email))) {
				if(aluno.getEmail().equals(corrige.corrigeEmail(email))) {
					int id = aluno.getId();
					System.out.println("Cadastro encontrado.");
					System.out.println("Digite 'Sim' para confirmar a exclusão.(Após a confirmação essa ação não poderá ser desfeita.) ");
					String confirmacao = teclado.next();
					if(sim.equals(corrige.corrigeConfirmacao(confirmacao))) {
						alunoService.repository.removerPorId(id);
					}
				}
			}
			
		}
	}
		
	public void mostrarTodosCadastrados() {
		
		pessoaService.mostrarTodosCadastrados();
		alunoService.mostrarTodosCadastrados();
		
	}
	
}
