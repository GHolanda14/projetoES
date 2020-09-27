package atracaoEvento;

import java.util.ArrayList;

import atracao.AtracaoDAO;
import evento.EventoDAO;

public class AtracaoEventoDAO {
	private static AtracaoEventoDAO atracaoEventoDAO;
	private ArrayList<AtracaoEventoEntidade> atracaoEvento;
	
	AtracaoEventoDAO() {
		atracaoEvento = new ArrayList<AtracaoEventoEntidade>();
	}
	
	public static AtracaoEventoDAO getInstance() {
		if(atracaoEventoDAO == null) {
			atracaoEventoDAO = new AtracaoEventoDAO();
		}
		return atracaoEventoDAO;
	}
	
	public boolean atracaoJaCadastrada(int atracao_id, int evento_id) {
		if(!atracaoEvento.isEmpty()) {
			for(AtracaoEventoEntidade ae : atracaoEvento) {
				if(ae.getEvento_id() == evento_id && ae.getAtracao_id() == atracao_id) {
					return true;
				}
			}
		}
		return false; 
	}
	
	public boolean incluirAtracaoEvento(int atracao_id, int evento_id) {
		AtracaoDAO atracaoDAO = AtracaoDAO.getInstance();
		EventoDAO eventoDAO = EventoDAO.getInstance();
		if(atracaoJaCadastrada(atracao_id, evento_id) ||
				!atracaoDAO.atracaoExiste(atracao_id) || !eventoDAO.eventoExiste(evento_id)){
			return false;
		}
		atracaoEvento.add(new AtracaoEventoEntidade(atracao_id,evento_id));
		return true;
	}
	
	public boolean retirarAtracaoEvento(int atracao_id, int evento_id) {
		for(AtracaoEventoEntidade ae : atracaoEvento) {
			if(ae.getAtracao_id() ==  atracao_id && ae.getEvento_id() == evento_id) {
				int id = atracaoEvento.indexOf(ae);
				atracaoEvento.remove(id);
				return true;
			}
		}
		return false;
	}

	public String listarAtracoesEvento(int evento_id) {
		AtracaoDAO atracaoDAO = AtracaoDAO.getInstance();
		String r = "";
		for(AtracaoEventoEntidade ae : atracaoEvento) {
			if(ae.getEvento_id() == evento_id) {
				r += atracaoDAO.buscaId(ae.getAtracao_id())+" | ";
			}
		}
		if(r.equals("")) {
			return "Sem atracoes";
		}
		return "Atracoes: "+r;
	}
}