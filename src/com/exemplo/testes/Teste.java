package com.exemplo.testes;

import com.exemplo.entidades.Cliente;
import com.exemplo.repositorio.RepositorioCliente;

public class Teste {

	public static void main(String[] args) {
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		//variavel do tipo criente recebe o metodo obterPorID da classe repositorioCLiente
		Cliente cliente = repositorioCliente.obterPorID(1);
		//a variavel cliente utiliza o metodo setNome para alterar o nome do campo nome no banco de dados
		cliente.setNome("Fernando santana");
		//variavel cliente usa o metodo serIdade para alterar o campo idade no banco
		cliente.setIdade(19);
		//metodo salvar da classe repositorioCLiente salva os dados contido em cliente fazendo assim o insert
		repositorioCliente.salvar(cliente);
		//exibe o nome
		System.out.println(cliente.getNome());
		
		 //metodo setNome altera o nome do cliente e na linha de baixo salva
		  cliente.setNome("Juninho");
		  repositorioCliente.salvar(cliente);
		//metodo remove remove o cliente da base de dados
		 repositorioCliente.remover(cliente);
		
	}
}
