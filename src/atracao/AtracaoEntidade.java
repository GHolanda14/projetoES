package atracao;

public class AtracaoEntidade {
	private int atracao_id;
	private String atracao_nome;
	private String atracao_email;
	private String atracao_telefone;
	
	AtracaoEntidade(int atracao_id, String atracao_nome, String atracao_email, String atracao_telefone){
		this.atracao_id = atracao_id;
		this.atracao_nome = atracao_nome;
		this.atracao_email = atracao_email;
		this.atracao_telefone = atracao_telefone;
	}
	
	public int getAtracao_id() {
		return atracao_id;
	}
	public String getAtracao_nome(){
		return atracao_nome;
	}
	public String toStringAdministrador() {
		return "Id: "+atracao_id+" => "+atracao_nome+"\nE-mail: "+atracao_email+"\nTelefone: "+atracao_telefone;
	}
}
