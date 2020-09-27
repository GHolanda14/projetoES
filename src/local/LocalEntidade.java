package local;

public class LocalEntidade {
	private int local_id;
	private String local_nome;
	private String local_bairro;
	private String local_rua;
	private int local_numero;
	private String local_pontoDeReferencia;
	private String local_telefone;
	
	public LocalEntidade(int local_id, String local_nome, String local_bairro, String local_rua, int local_numero,
			String local_pontoDeReferencia, String local_telefone) {
		this.local_id = local_id;
		this.local_nome = local_nome;
		this.local_bairro = local_bairro;
		this.local_rua = local_rua;
		this.local_numero = local_numero;
		this.local_pontoDeReferencia = local_pontoDeReferencia;
		this.local_telefone = local_telefone;
	}
	
	public String toStringAdministrador() {
		return "Id: "+local_id+" -> "+local_nome+"\nBairro: "+local_bairro+
				"\nEndereço: "+local_rua+", Nº "+local_numero+"\nPonto de referencia: "+
				local_pontoDeReferencia+"\nContato: "+local_telefone;
	}
	public String toStringParticipante() {
		return local_nome+"\nBairro: "+local_bairro+"\nEndereço: "+local_rua+
				", Nº "+local_numero+"\nPonto de referencia"+
				local_pontoDeReferencia+"\nContato: "+local_telefone;
	}
	
	public int getLocal_id() {
		return local_id;
	}
	
	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}
	
	public String getLocal_nome() {
		return local_nome;
	}
}
