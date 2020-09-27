package evento;

import java.util.ArrayList;

public class EventoControlador {
	private static EventoControlador eventoControlador;
	EventoDAO eventoDAO = EventoDAO.getInstance();
	
	EventoControlador(){
	}
	
	public static EventoControlador getInstance() {
		if(eventoControlador == null) {
			eventoControlador = new EventoControlador();
		}
		return eventoControlador;
	}
	
	public boolean cadastrarEvento(EventoEntidade value) {
		if(eventoDAO.cadastrarEvento(value)){
				return true;
		}
		return false;
	}
	
	public boolean excluirEvento(int id) {
		if(eventoDAO.excluirEvento(id)){
				return true;
		}
		return false;
	}
	
	public ArrayList<EventoEntidade> listareventos(){
		return eventoDAO.listarEvento();
	}
	
	public boolean eventoExiste(int id) {
		return eventoDAO.eventoExiste(id);
	}
	
	public ArrayList<EventoEntidade> listarPorBairro(ArrayList<Integer> ids){
		return eventoDAO.listarPorBairro(ids);
	}
}
