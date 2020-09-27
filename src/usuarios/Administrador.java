package usuarios;

import atracao.AtracaoFronteira;
import evento.EventoFronteira;
import local.LocalFronteira;
import menu.Menu;

import java.util.Scanner;

public class Administrador {
	private Scanner input;
	Menu menu = new Menu();
	public void escolheGerencia(int classe) {
		input = new Scanner(System.in);
		int comando;
		do{
			switch(classe) {
				case 1:
					menu.menuCRUD();
					comando = input.nextInt();
					gerenciarEvento(comando);
					break;
				case 2:
					menu.menuCRUD();
					comando = input.nextInt();
					gerenciarLocal(comando);
					break;
				case 3:
					menu.menuCRUD();
					comando = input.nextInt();
					gerenciarAtracao(comando);
					break;
				case 0:
					comando = 0;
					break;
				default:
					System.out.println("Opcao invalida");
					return;
			}
		}
		while(comando != 0);
	}
	public void gerenciarEvento(int comando) {
		EventoFronteira eventoFronteira = new EventoFronteira();
		switch(comando) {
			case 1:
				eventoFronteira.cadastrarEvento();
				break;
			case 2:
				eventoFronteira.excluirEvento();
				break;
			case 3:
				eventoFronteira.listarAtracoes(1);
				break;
			case 0:
				comando = 0;
				break;
			default:
				System.out.println("Opcao invalida");
				return;
		}
	}
	
	public void gerenciarLocal(int comando) {
		LocalFronteira localFronteira = new LocalFronteira();
		switch(comando) {
		case 1:
			localFronteira.cadastrarLocal();
			break;
		case 2:
			localFronteira.excluirLocal();
			break;
		case 3:
			localFronteira.listarAtracoesAdm();
			break;
		case 0:
			comando = 0;
			break;
		default:
			System.out.println("Opcao invalida");
			return;
		}
	}
	
	public void gerenciarAtracao(int comando) {
		AtracaoFronteira atracaoFronteira = new AtracaoFronteira();
		switch(comando) {
			case 1:
				atracaoFronteira.cadastrarAtracao();
				break;
			case 2:
				atracaoFronteira.excluirAtracao();
				break;
			case 3:
				atracaoFronteira.listarAtracoes();
				break;
			case 4:
				atracaoFronteira.incluirAtracao();
				break;
			case 5:
				atracaoFronteira.retirarAtracao();
				break;
			case 0:
				comando = 0;
				break;
			default:
				System.out.println("Opcao invalida");
				return;
		}
	}
}
