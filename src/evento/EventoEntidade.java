package evento;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoEntidade {
	private int evento_id;
	private String evento_nome;
	private String evento_descricao;
	private LocalDate evento_data;
	private LocalTime evento_horario;
	private int evento_local;
	private String evento_atracoes;
	
	public EventoEntidade(int evento_id, String evento_nome, String evento_descricao, LocalDate evento_data,
			LocalTime evento_horario, int evento_local) {
		this.evento_id = evento_id;
		this.evento_nome = evento_nome;
		this.evento_descricao = evento_descricao;
		this.evento_data = evento_data;
		this.evento_horario = evento_horario;
		this.evento_local = evento_local;
	}
	
	public String toStringAdministrador() {
		String[] dat;
		dat = evento_data.toString().split("-");
		
		return "Id: "+evento_id+" -> "+evento_nome+"\nDescricao: "+evento_descricao+"\nData: "+dat[2]+"/"+dat[1]+"/"+dat[0]+"\nHorario: "+
				evento_horario.toString()+"\n"+evento_atracoes;
	}
	
	public String toStringParticipante() {
		String[] dat;
		dat = evento_data.toString().split("-");
		
		return "["+evento_nome+"]\nDescricao: "+evento_descricao+"\nData: "+dat[2]+"/"+dat[1]+"/"+dat[0]+"\nHorario: "+
		evento_horario.toString()+"\n"+evento_atracoes;
	}
	
	public int getEvento_id() {
		return evento_id;
	}
	
	public int getEvento_local() {
		return evento_local;
	}
	
	public void setEvento_atracoes(String evento_atracoes) {
		this.evento_atracoes = evento_atracoes;
	}
}
