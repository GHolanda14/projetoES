package principal;

import menu.Menu;
import usuarios.Administrador;
import usuarios.Participante;
 
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Menu menu = new Menu();
		Scanner input = new Scanner(System.in);
		int usuario, operacao;
		
		do{
			menu.menuEscolheUsuario();
			usuario = input.nextInt();
			if(usuario == 1){
				Administrador adm = new Administrador();
				do {
					menu.menuAdministrador();
					operacao = input.nextInt();
					adm.escolheGerencia(operacao);
				}
				while(operacao != 0);
			}
			else if(usuario == 2){
				Participante part = new Participante();
				do {
					menu.menuParticipante();
					operacao = input.nextInt();
					if(operacao == 1) {
						part.listarEventos();
					}
					else if(operacao == 2) {
						part.listarInformacoesLocal();
					}
				}
				while(operacao != 0);
			}
		}
		while(usuario != 0);
		System.out.println("Volte sempre!");
		input.close();
	}
}
