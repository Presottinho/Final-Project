package menu;

import java.util.Scanner;

import util.dataAtual;

public class Menu {

	public static void menu1() {
		System.out.println("========================================");
		System.out.println("Seja Bem Vindo ao sistema.");
		System.out.println("1 - Cadastrar Pessoa ou Aluno.");
		System.out.println("2 - Listar Pessoas e Alunos já cadastrados.");
		System.out.println("3 - Atualizar dados de uma Pessoa ou Aluno.");
		System.out.println("4 - Deletar Pessoa ou Aluno cadastrado.");
		System.out.println("0 - Sair do programa.");
	}
	
	public static void atualizacao() {
		System.out.println("========================================");
		System.out.println("Digite o número corresponde ao dado que deseja atualizar? ");
		System.out.println("1 - Nome");
		System.out.println("2 - Sobrenome");
		System.out.println("3 - Email");
		System.out.println("4 - Telefone");
		System.out.println("5 - Data de nascimento");
		System.out.println("6 - Nota Final");
		System.out.println("0 - Sair do programa.");
	}
	
	public static void removerCadastro() {
		System.out.println("========================================");
		System.out.println("Digite o email do cadastro que deseja remover: ");
	}
	
	public static void menu2() {
		System.out.println("========================================");
		System.out.println("Seja Bem Vindo ao sistema.");
		System.out.println("0 - Sair do programa.");
	}
	
}
