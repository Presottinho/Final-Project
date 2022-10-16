import java.util.InputMismatchException;
import java.util.Scanner;

import menu.Menu;
import model.Aluno;
import model.Pessoa;
import service.AlunoService;
import service.PessoaService;
import service.Service;
import util.corrige;
import util.dataAtual;
import exception.SistemaException;

public class Main {

	public static void main(String[] args) throws InterruptedException, SistemaException {
		Scanner teclado = new Scanner(System.in);
		
		AlunoService alunoService = new AlunoService(teclado);
		Service service = new Service(teclado);
		PessoaService pessoaService = new PessoaService(teclado);
		String email;
		
		boolean continua = true;
		do {		
			try {
			Menu.menu1();
			int opcao1 = teclado.nextInt();
			
			switch(opcao1) {
			case 1:
				System.out.println("Digite seu email: ");
				email = teclado.next();
				service.confereEmail(email);
				
				break;
			case 2:
				
				service.mostrarTodosCadastrados();
				
				break;
			case 3:
				
				System.out.println("Digite o email cadastrado: ");
				email = teclado.next();
				service.confereEmailAtualizacao(email);
				
				break;
			case 4:
				
				Menu.removerCadastro();
				email = teclado.next();
				service.removerCadastro(email);
				
				break;
			case 0:
				continua = false;
				break;
			default:
				System.out.println("Alternativa inválida. Tente novamente");
			}
			}catch(InputMismatchException e){
				System.out.println("Opção inválida, tente novamente.");
				teclado.next();
			}finally{
				Thread.sleep(1500l);
			}
		}while(continua);
		
		
		
		teclado.close();
		
	}

}
