package br.ufrj.hucff.controleestoque.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.ufrj.hucff.controleestoque.JPAUtil.JPAUtil;
import br.ufrj.hucff.controleestoque.modelo.Categoria;
import br.ufrj.hucff.controleestoque.modelo.ItemEstoque;

public class DAOGeneric<E> {

	public void salvar(E entidade) {
		EntityManager em = JPAUtil.geEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(entidade);
		et.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemEstoque> listaItemEstoque() {
		EntityManager em = JPAUtil.geEntityManager();
		String query = "from ItemEstoque";
		List<ItemEstoque> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listaCategoria() {
		EntityManager em = JPAUtil.geEntityManager();
		String query = "from Categoria";
		List<Categoria> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}
	
}