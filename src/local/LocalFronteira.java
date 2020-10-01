package local;

import java.util.ArrayList;
import java.util.Scanner;

public class LocalFronteira {
	LocalControlador localControlador = LocalControlador.getInstance();
	Scanner input = new Scanner(System.in);
	public void cadastrarLocal() {
		int id,numero;
		String nome,bairro,rua,pontoDeReferencia,telefone;
		
		System.out.print("Id: ");
		id = input.nextInt();
		
		if(!localControlador.localExiste(id)) {
			input.nextLine();
			System.out.print("Nome: ");
			nome = input.nextLine();
			
			System.out.print("Bairro: ");
			bairro = input.nextLine();
			
			System.out.print("Rua: ");
			rua = input.nextLine();
			
			System.out.print("Número: ");
			numero = input.nextInt();
			input.nextLine();
			
			System.out.print("Ponto de Referência: ");
			pontoDeReferencia = input.nextLine();
			
			System.out.print("Telefone (XX) XXXXX-XXXX: ");
			telefone = input.nextLine();
			if(!nome.equals("") && !bairro.equals("") && !rua.equals("") && !telefone.equals("")) {
				LocalEntidade e = new LocalEntidade(id, nome, bairro, rua, numero, pontoDeReferencia, telefone);
				if(localControlador.cadastrarLocal(e)) {
					System.out.println("Cadastrado com sucesso!");
				}
				else{
					System.out.println("Erro ao tentar cadastrar");	
				}
			}
			else {
				System.out.println("Existem campos vazios, tente novamente!");
			}
		}
		else {
			System.out.println("Esse id já esta cadastrado!");
		}
		
	}
	
	public void excluirLocal() {
		listarLocais();
		if(!localControlador.listarlocais().isEmpty()) {
			System.out.print("Digite o id: ");
			if(localControlador.excluirLocal(input.nextInt())) {
				System.out.println("Deletado com sucesso!");
			}
			else {
				System.out.println("Erro ao tentar deletar");
			}
		}
	}
	
	public void listarLocais() {
		ArrayList <LocalEntidade> locais = localControlador.listarlocais();
		if(locais.isEmpty()) {
			System.out.println("Não exitem locais");
		}
		else {
			for(LocalEntidade l : locais) {
				System.out.println(l.toStringAdministrador());
				System.out.println("-----------------------------------------------------------------");
			}
		}
	}
	
	public void listarInformacoesLocal() {
		System.out.print("Nome: ");
		String nome = input.nextLine();
		ArrayList<LocalEntidade> locais = localControlador.listarInformacoesLocal(nome);
		
		if(locais.isEmpty()) {
			System.out.println("Não exitem locais");
		}
		else {
			for(LocalEntidade l : locais) {
				System.out.println(l.toStringParticipante());
				System.out.println("-----------------------------------------------------------------");
			}
		}
	}
}
