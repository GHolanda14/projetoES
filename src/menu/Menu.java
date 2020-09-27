package menu;

import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	public void menuAdministrador() {
		System.out.println("1 - Evento");
		System.out.println("2 - Local");
		System.out.println("3 - Atracao");
		System.out.println("0 - Voltar");
	}
	
	public void menuCRUD() {
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Excluir");
		System.out.println("3 - Listar");
		System.out.println("0 - Voltar");
	}
	
	public void menuAtracaoEvento() {
		System.out.println("4 - Incluir atracao em um evento");
		System.out.println("5 - Excluir atracao de um evento");
		System.out.println("0 - Voltar");
	}
	
	public void menuEscolheUsuario() {
		System.out.println("1 - Administrador");
		System.out.println("2 - Participante");
		System.out.println("0 - Encerrar");
	}
	
	public void menuParticipante() {
		System.out.println("1 - Lista de eventos");
		System.out.println("2 - Listar informacoes do local");
		System.out.println("0 - Voltar");
	}
}
