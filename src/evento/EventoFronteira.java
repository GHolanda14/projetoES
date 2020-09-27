package evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import local.LocalControlador;

public class EventoFronteira {
	EventoControlador eventoControlador = EventoControlador.getInstance();
	LocalControlador localControlador = LocalControlador.getInstance();
	Scanner input = new Scanner(System.in);
	public void cadastrarEvento() {
		int id,local;
		String nome,descricao,date,time;
		
		System.out.print("Id: ");
		id = input.nextInt();
		input.nextLine();
		if(!eventoControlador.eventoExiste(id)) {
			System.out.print("Nome: ");
			nome = input.nextLine();
			
			System.out.print("Data(AAAA-MM-DD): ");
			date = input.nextLine();
			LocalDate data = LocalDate.parse(date);
			
			System.out.print("Horario(HH:MM): ");
			time = input.nextLine();
			LocalTime horario = LocalTime.parse(time);
	
			System.out.print("Id do local: ");
			local = input.nextInt();
			input.nextLine();
			
			System.out.print("Descricao: ");
			descricao = input.nextLine();
			
			if(localControlador.localExiste(local)) {
				EventoEntidade e = new EventoEntidade(id, nome, descricao, data, horario, local);
				if(eventoControlador.cadastrarEvento(e)) {
					System.out.println("Cadastrado com sucesso!");
				}else {
					System.out.println("Deu ruim");
				}
			}
			else {
				System.out.println("Esse local nao existe!");
			}
		}
		else {
			System.out.println("Esse id ja esta cadastrado!");
		}
	}
	
	public void excluirEvento() {
		System.out.print("Digite o id: ");
		if(eventoControlador.excluirEvento(input.nextInt())) {
			System.out.println("Deletado com sucesso!");
		}
		else {
			System.out.println("Deu ruim");
		}
	}
	
	public void listarAtracoes(int usuario) {
		ArrayList <EventoEntidade> eventos = eventoControlador.listareventos();
		if(eventos.isEmpty()) {
			System.out.println("Nao exitem eventos");
		}
		else {
			for(EventoEntidade a : eventos) {
				if(usuario == 1) {
					System.out.println(a.toStringAdministrador());
				}
				else {
					System.out.println(a.toStringParticipante());
				}
				System.out.println("Local: "+localControlador.buscaId(a.getEvento_local()));
				System.out.println("-----------------------------------------------------------------");
			}
		}
	}
}
