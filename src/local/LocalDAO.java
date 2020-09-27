package local;

import java.util.ArrayList;

public class LocalDAO {
	ArrayList<LocalEntidade> locais = new ArrayList<LocalEntidade>();
	private static LocalDAO localDAO;
	
	LocalDAO(){
	}
	
	public static LocalDAO getInstance() {
		if(localDAO == null) {
			localDAO = new LocalDAO();
		}
		return localDAO;
	}
	
	public boolean cadastrarLocal(LocalEntidade value) {
		if(locais.add(value)) {
			return true;
		}
		return false;
	}
	
	public boolean excluirLocal(int id) {
		for(LocalEntidade l : locais) {
			if(l.getLocal_id() == id) {
				id = locais.indexOf(l);
				locais.remove(id);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<LocalEntidade> listarLocal(){
		return locais;
	}
	
	public ArrayList<LocalEntidade> listarInformacoesLocal(String nome_local) {
		ArrayList<LocalEntidade> lista = new ArrayList<LocalEntidade>();
		for(LocalEntidade l : locais) {
			if(l.getLocal_nome().contains(nome_local)) {
				lista.add(l);
			}
		}
		return lista;
	}
	
	public String buscaId(int id) {
		for(LocalEntidade l : locais) {
			if(l.getLocal_id() == id) {
				return l.getLocal_nome();
			}
		}
		return "";
	}
	
	public boolean localExiste(int id) {
		for(LocalEntidade l : locais) {
			if(l.getLocal_id() == id) {
				return true;
			}
		}
		return false;
	}
}
