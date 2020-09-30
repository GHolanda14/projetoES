package usuarios;

import evento.EventoFronteira;
import local.LocalFronteira;
import java.util.Scanner;
public class Participante {	
	private Scanner input = new Scanner(System.in);
	public void listarEventos() {
		EventoFronteira eventoFronteira = new EventoFronteira();
		eventoFronteira.listarTodosEventos(2);
	}
	public void listarInformacoesLocal() {
		LocalFronteira localFronteira = new LocalFronteira();
		localFronteira.listarInformacoesLocal();
	}
	public void listarPorBairro() {
		System.out.print("Nome do bairro: ");
		String nome = input.nextLine();
		EventoFronteira eventoFronteira = new EventoFronteira();
		eventoFronteira.listarPorBairros(nome);
	}
	
	public void escolheOpcao(int opcao) {
		switch(opcao) {
			case 1:
				listarEventos();
				break;
			case 2:
				listarPorBairro();
				break;
			case 3:
				listarInformacoesLocal();
				break;
			case 0:
				opcao = 0;
				break;
			default:
				System.out.println("Opcao invalida");
				return;
		}
	}
	
}
