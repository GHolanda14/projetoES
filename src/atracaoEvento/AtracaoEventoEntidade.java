package atracaoEvento;

public class AtracaoEventoEntidade {
	private int atracao_id;
	private int evento_id;
	
	public AtracaoEventoEntidade(int atracao_id, int evento_id) {
		this.atracao_id = atracao_id;
		this.evento_id = evento_id;
	}
	
	public int getAtracao_id() {
		return atracao_id;
	}
	public int getEvento_id() {
		return evento_id;
	}
	
}


