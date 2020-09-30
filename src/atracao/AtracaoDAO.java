package atracao;

import java.util.ArrayList;

public class AtracaoDAO {
	private ArrayList <AtracaoEntidade> atracoes;
	private static AtracaoDAO atracaoDAO;
	AtracaoDAO(){
		atracoes = new ArrayList <AtracaoEntidade>();
	}
	
	public static AtracaoDAO getInstance(){
		if(atracaoDAO == null) {
			atracaoDAO = new AtracaoDAO();
		}
		return atracaoDAO;
	}
	
	public boolean cadastrarAtracao(AtracaoEntidade value) {
		if(atracoes.add(value)) {
			return true;
		}		
		return false;
	}
	
	public boolean excluirAtracao(int id) {
		for(AtracaoEntidade a : atracoes) {
			if(a.getAtracao_id() == id) {
				id = atracoes.indexOf(a);
				atracoes.remove(id);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<AtracaoEntidade> listarAtracao(){
		return atracoes;
	}
	
	public boolean atracaoExiste(int id){
		for(AtracaoEntidade a : atracoes) {
			if(a.getAtracao_id() == id) {
				return true;
			}
		}
		return false;
	}
	
	public String buscaId(int id) {
		for(AtracaoEntidade a : atracoes) {
			if(a.getAtracao_id() == id) {
				return a.getAtracao_nome();
			}
		}
		return "";
	}
}
