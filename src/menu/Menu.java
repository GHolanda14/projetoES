package menu;

import java.util.Scanner;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	public void menuAdministrador() {
		System.out.println("1 - Evento");
		System.out.println("2 - Local");
		System.out.println("3 - Atração");
		System.out.println("0 - Voltar");
	}
	
	public String menuCRUD() {
		return "1 - Cadastrar\n2 - Excluir\n3 - Listar\n0 - Voltar";
	}
	
	public void menuEscolheUsuario() {
		System.out.println("1 - Administrador");
		System.out.println("2 - Participante");
		System.out.println("0 - Encerrar");
	}
	
	public void menuParticipante() {
		System.out.println("1 - Lista de eventos");
		System.out.println("2 - Listar eventos por bairro");
		System.out.println("3 - Listar informações do local");
		System.out.println("0 - Voltar");
	}
}
