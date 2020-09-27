package usuarios;

import evento.EventoFronteira;
import local.LocalFronteira;

public class Participante {	
	
	public void listarEventos() {
		EventoFronteira eventoFronteira = new EventoFronteira();
		eventoFronteira.listarAtracoes(2);
	}
	public void listarInformacoesLocal() {
		LocalFronteira localFronteira = new LocalFronteira();
		localFronteira.listarInformacoesLocal();
	}
	
	
}
