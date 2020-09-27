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
			if(data.isAfter(LocalDate.now())){
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
				System.out.println("A data tem que ser superior a atual");
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
	
	public void listarEventos(int usuario, ArrayList<EventoEntidade> eventos) {
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
	
	public void listarPorBairros(int usuario){
		System.out.print("Nome do bairro: ");
		String nome = input.nextLine();
		ArrayList<Integer> ids = localControlador.pegarIds(nome);
		ArrayList<EventoEntidade> eventos = eventoControlador.listarPorBairro(ids);
		listarEventos(usuario,eventos);
	}
	
	public void listarTodosEventos(int usuario) {
		ArrayList <EventoEntidade> eventos = eventoControlador.listareventos();
		listarEventos(usuario,eventos);
	}
}
