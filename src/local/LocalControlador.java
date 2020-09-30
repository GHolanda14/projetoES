package local;

import java.util.ArrayList;

public class LocalControlador {
	private static LocalControlador localControlador;
	private LocalDAO localDAO = LocalDAO.getInstance();
	
	LocalControlador(){
	}
	
	public static LocalControlador getInstance() {
		if(localControlador == null) {
			localControlador = new LocalControlador();
		}
		return localControlador;
	}
	
	public boolean cadastrarLocal(LocalEntidade value) {
		if(localDAO.cadastrarLocal(value)){
				return true;
		}
		return false;
	}
	
	public boolean excluirLocal(int id) {
		if(localDAO.excluirLocal(id)){
				return true;
		}
		return false;
	}
	
	public ArrayList<LocalEntidade> listarlocais(){
		return localDAO.listarLocal();
	}
	
	public ArrayList<LocalEntidade> listarInformacoesLocal(String nome_local) {
		return localDAO.listarInformacoesLocal(nome_local); 
	}
	
	public String buscaId(int id) {
		return localDAO.buscaId(id);
	}
	
	public boolean localExiste(int id) {
		return localDAO.localExiste(id);
	}
	
	public ArrayList<Integer> pegarIds(String nome) {
		return localDAO.pegarIds(nome);
	}
}
