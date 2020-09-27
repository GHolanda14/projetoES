package usuarios;

import evento.EventoFronteira;
import local.LocalFronteira;

public class Participante {	
	
	public void listarEventos() {
		EventoFronteira eventoFronteira = new EventoFronteira();
		eventoFronteira.listarTodosEventos(2);
	}
	public void listarInformacoesLocal() {
		LocalFronteira localFronteira = new LocalFronteira();
		localFronteira.listarInformacoesLocal();
	}
	public void listarPorBairro() {
		EventoFronteira eventoFronteira = new EventoFronteira();
		eventoFronteira.listarPorBairros(2);
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
