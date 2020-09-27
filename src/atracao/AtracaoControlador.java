package atracao;

import java.util.ArrayList;

import atracaoEvento.AtracaoEventoDAO;

public class AtracaoControlador {
	private static AtracaoControlador atracaoControlador;
	AtracaoDAO atracaoDAO = AtracaoDAO.getInstance();
	
	AtracaoControlador(){
	}
	
	public static AtracaoControlador getInstance() {
		if(atracaoControlador == null) {
			atracaoControlador = new AtracaoControlador();
		}
		return atracaoControlador;
	}
	
	public boolean cadastrarAtracao(AtracaoEntidade value) {
		return atracaoDAO.cadastrarAtracao(value);
	}
	
	public boolean excluirAtracao(int id) {
		return atracaoDAO.excluirAtracao(id);
	}
	
	public ArrayList<AtracaoEntidade> listarAtracoes(){
		return atracaoDAO.listarAtracao();
	}
	
	public boolean incluirAtracao(int atracao_id, int evento_id) {
		AtracaoEventoDAO atracaoEventoDAO = AtracaoEventoDAO.getInstance();
		return atracaoEventoDAO.incluirAtracaoEvento(atracao_id, evento_id); 
	}
	
	public boolean retirarAtracao(int atracao_id, int evento_id) {
		AtracaoEventoDAO atracaoEventoDAO = AtracaoEventoDAO.getInstance();
		return atracaoEventoDAO.retirarAtracaoEvento(atracao_id, evento_id);
	}
	
	public boolean atracaoExiste(int id) {
		return atracaoDAO.atracaoExiste(id);
	}
}
