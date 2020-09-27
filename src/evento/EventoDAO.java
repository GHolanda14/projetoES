package evento;

import java.util.ArrayList;

import atracaoEvento.AtracaoEventoDAO;

public class EventoDAO {
	ArrayList<EventoEntidade> eventos;
	private static EventoDAO eventoDAO;
	
	EventoDAO(){
		eventos = new ArrayList<EventoEntidade>();
	}
	
	public static EventoDAO getInstance() {
		if(eventoDAO == null) {
			eventoDAO = new EventoDAO();
		}
		return eventoDAO;
	}
	
	public boolean cadastrarEvento(EventoEntidade value) {
		if(eventos.add(value)) {
			return true;
		}
		return false;
	}
	
	public boolean excluirEvento(int id) {
		for(EventoEntidade e : eventos) {
			if(e.getEvento_id() == id) {
				id = eventos.indexOf(e);
				eventos.remove(id);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<EventoEntidade> listarEvento(){
		AtracaoEventoDAO atracaoEventoDAO = AtracaoEventoDAO.getInstance();
		for(EventoEntidade e : eventos) {
			e.setEvento_atracoes(atracaoEventoDAO.listarAtracoesEvento(e.getEvento_id()));
		}
		return eventos;
	}
	
	public boolean eventoExiste(int id) {
		for(EventoEntidade a : eventos) {
			if(a.getEvento_id() == id) {
				return true;
			}
		}
		return false;
	}
}
