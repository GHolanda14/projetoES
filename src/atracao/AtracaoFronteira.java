package atracao;

import java.util.ArrayList;
import java.util.Scanner;

public class AtracaoFronteira {
	private AtracaoControlador atracaoControlador = AtracaoControlador.getInstance();
	Scanner input = new Scanner(System.in);
	public void cadastrarAtracao() {
		int id;
		String nome,email,telefone;
		
		System.out.print("Id: ");
		id = input.nextInt();
		input.nextLine();
		if(!atracaoControlador.atracaoExiste(id)) {
			System.out.print("Nome: ");
			nome = input.nextLine();	
			
			System.out.print("Email: ");
			email = input.nextLine();
			
			System.out.print("Telefone (XX) XXXXX-XXXX: ");
			telefone = input.nextLine();
			if(!nome.equals("") && !email.equals("") && !telefone.equals("")) {
				AtracaoEntidade e = new AtracaoEntidade(id,nome,email,telefone);
				if(atracaoControlador.cadastrarAtracao(e)) {
					System.out.println("Cadastrado com sucesso!");
				}
				else {
					System.out.println("Erro ao tentar cadastrar");
				}
			}
			else {	
				System.out.println("Existem campos vazios, tente novamente!");
			}
		}else {
			System.out.println("Esse id já está cadastrado!");
		}
	}
	
	public void excluirAtracao() {
		listarAtracoes();
		if(!atracaoControlador.listarAtracoes().isEmpty()) {
			System.out.print("Digite o id: ");
			if(atracaoControlador.excluirAtracao(input.nextInt())) {
				System.out.println("Deletado com sucesso!");
			}
			else {
				System.out.println("Erro ao tentar deletar");
			}
		}
	}
	
	public void listarAtracoes() {
		ArrayList <AtracaoEntidade> atracoes = atracaoControlador.listarAtracoes();
		if(atracoes.isEmpty()) {
			System.out.println("Não exitem atracoes");
		}
		else {
			for(AtracaoEntidade a : atracoes) {
				System.out.println(a.toStringAdministrador());
				System.out.println("-----------------------------------------------------------------");
			}
		}
	}
	
	public void incluirAtracao() {
		int atracao_id,evento_id;
		System.out.print("Id atracao: ");
		atracao_id = input.nextInt();
		System.out.print("Id evento: ");
		evento_id = input.nextInt();
		
		if(atracaoControlador.incluirAtracao(atracao_id, evento_id)) {
			System.out.println("Atração incluida ao evento com sucesso!");
		}
		else {
			System.out.println("Erro ao tentar incluir a atração do evento");
		}
	}
	
	public void retirarAtracao() {
		int atracao_id,evento_id;
		System.out.print("Id atração: ");
		atracao_id = input.nextInt();
		System.out.print("Id evento: ");
		evento_id = input.nextInt();
		
		if(atracaoControlador.retirarAtracao(atracao_id, evento_id)){
			System.out.println("Atração retirada do evento com sucesso!");
		}
		else {
			System.out.println("Erro ao tentar retirar a atração do evento");
		}
	}
}
