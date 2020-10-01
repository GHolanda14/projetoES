package evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import local.LocalControlador;

public class EventoFronteira {
	private EventoControlador eventoControlador = EventoControlador.getInstance();
	private LocalControlador localControlador = LocalControlador.getInstance();
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
			
			System.out.print("Horário(HH:MM): ");
			time = input.nextLine();
	
			System.out.print("Id do local: ");
			local = input.nextInt();
			input.nextLine();
			
			System.out.print("Descrição: ");
			descricao = input.nextLine();
			if(!nome.equals("") && !date.equals("") && !time.equals("") && descricao.equals("")) {
				LocalDate data = LocalDate.parse(date);
				if(data.isAfter(LocalDate.now())){
					LocalTime horario = LocalTime.parse(time);
					if(localControlador.localExiste(local)) {
						EventoEntidade e = new EventoEntidade(id, nome, descricao, data, horario, local);
						if(eventoControlador.cadastrarEvento(e)) {
							System.out.println("Cadastrado com sucesso!");
						}else {
							System.out.println("Erro ao tentar cadastrar");
						}
					}
					else {
						System.out.println("Esse local não existe!");
					}
				}
				else {
					System.out.println("A data tem que ser superior a atual");
				}
			}
			else {
				System.out.println("Existem campos vazios, tente novamente!");
			}
			
	}
	else {
		System.out.println("Esse id já está cadastrado!");
	}
}
	
	public void excluirEvento() {
		listarTodosEventos(1);
		if(!eventoControlador.listareventos().isEmpty()) {
			System.out.print("Digite o id: ");
			if(eventoControlador.excluirEvento(input.nextInt())) {
				System.out.println("Deletado com sucesso!");
			}
			else {
				System.out.println("Erro ao tentar deletar");
			}
		}
	}
	
	public void listarEventos(int usuario, ArrayList<EventoEntidade> eventos) {
		if(eventos.isEmpty()) {
			System.out.println("Não exitem eventos");
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
	
	public void listarPorBairros(String nome){
		ArrayList<Integer> ids = localControlador.pegarIds(nome);
		ArrayList<EventoEntidade> eventos = eventoControlador.listarPorBairro(ids);
		listarEventos(2,eventos);
	}
	
	public void listarTodosEventos(int usuario) {
		ArrayList <EventoEntidade> eventos = eventoControlador.listareventos();
		listarEventos(usuario,eventos);
	}
}
