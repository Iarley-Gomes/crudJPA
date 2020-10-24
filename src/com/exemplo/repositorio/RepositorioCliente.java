package com.exemplo.repositorio;
import java.util.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.exemplo.entidades.Cliente;

public class RepositorioCliente {
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioCliente() {
		emf = Persistence.createEntityManagerFactory("santana");
		em = emf.createEntityManager();
		
	}
	
	public Cliente obterPorID(int id) {
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.getTransaction().commit();
		emf.close();
		return cliente;
	}
	
	public void salvar(Cliente c) {
		//abre a conexao
		em.getTransaction().begin();
		em.merge(c);//se ja existir o dado no banco ele tenta atualziar
		//executa oque tiver de executar
		em.getTransaction().commit();
		//fecha a conexao
		emf.close();
	};
	
	public void remover(Cliente c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		emf.close();
	};
	
	public List<Cliente> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clientes;
	}
}
